package control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import clases.Articulo;
import clases.ArticuloDAO;
import clases.ArticulosForm;
import clases.Compra;
import clases.CompraDAO;
import clases.Empresa;
import clases.EmpresaDAO;
import clases.EmpresaForm;
import clases.Venta;
import clases.VentaDAO;


@Controller
public class CarritoController {
	
	
	private static List<Articulo> articulos = new ArrayList<Articulo>();
	private static List<Articulo> articulosCompra = new ArrayList<Articulo>();
	private static  List<Empresa> empresas = new ArrayList<Empresa>();
	private static Double total;
	private static Double totalimpuesto;
	
		
	@RequestMapping(value = "/entrar", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute ("articuloForm") ArticulosForm articuloForm ) {
		total=0.0;
		
		//Llama al método de la clase DAO para hacer la consulta de los artículos
		
		ArticuloDAO artDao = new ArticuloDAO();
		articulos = artDao.findAll();
		articuloForm.setArticulos(articulos);
		return new ModelAndView("seleccion", "articuloForm", articuloForm);
	}
	

	//En esta petición no se usa la Base de datos, ya que los datos son volátiles 
	
	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar(Model model, @RequestParam Map<String,String> requestParams) {

		ArticulosForm articuloForm = new ArticulosForm();
		ArticulosForm articuloCompra = new ArticulosForm();
		articuloForm.setArticulos(articulos);
		for (Articulo articulo : articulos) {
		
			
			if(requestParams.get("Elemento"+articulo.getId()) != null){
				Integer cantidad =(Integer.parseInt(requestParams.get("Elemento"+articulo.getId()).toString()));
				
				
				if(cantidad>0){

					if(articulosCompra.contains(articulo)){
						articulosCompra.remove(articulo);
						cantidad = cantidad + articulo.getCantidad();
						
						
						total -= articulo.getTotal();
					}
					articulo.setCantidad(cantidad);
					articulo.setTotal(articulo.getCantidad()*articulo.getPrecio());
					
					articulosCompra.add(articulo);					
					total += articulo.getTotal();
					
				}
			}
			
		}
		
		articuloCompra.setArticulos(articulosCompra);
		
		model.addAttribute("total", total);
		model.addAttribute("articuloForm", articuloForm);
		model.addAttribute("articuloCompra", articuloCompra);
		
		return "seleccion";
	}

	
	//En esta petición no se usa la Base de datos, ya que los datos son volátiles
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.GET)
	public String actualizarr(Model model, @RequestParam Map<String,String> requestParams) {

		ArticulosForm articuloForm = new ArticulosForm();
		ArticulosForm articuloCompra = new ArticulosForm();
		articuloForm.setArticulos(articulos);
				
		for (Articulo articulo : articulos) {
		
			if(requestParams.get("chk"+articulo.getId()) != null){
						total -= articulo.getTotal();
						articulosCompra.remove(articulo);
						
						
				
			}
			
		}
		
		articuloCompra.setArticulos(articulosCompra);
		model.addAttribute("total", total);
		model.addAttribute("articuloForm", articuloForm);
		model.addAttribute("articuloCompra", articuloCompra);
		
		return "seleccion";
	}

	
	
	//Limpia página e inicializa datos
	@RequestMapping(value = "/limpiar", method = RequestMethod.GET)
	public ModelAndView limpiar(@ModelAttribute ("articuloForm") ArticulosForm articuloForm ) {

		
		ArticuloDAO artDao = new ArticuloDAO();
		articulos = artDao.findAll();		
		articuloForm.setArticulos(articulos);
		articulosCompra.clear();
		total = 0.0;
		
		return new ModelAndView("seleccion", "articuloForm", articuloForm);
	}
	
	
	
	//Realiza la compra
	@RequestMapping(value = "/comprar", method = RequestMethod.GET)
	public String comprar(Locale locale, Model model) {

	
		ArticulosForm articuloCompra = new ArticulosForm();
		articuloCompra.setArticulos(articulosCompra);
		ArticuloDAO artDao = new ArticuloDAO();
		EmpresaForm empresaForm = new EmpresaForm();
		EmpresaDAO empDao = new EmpresaDAO();
		empresas = empDao.findAll();		
		empresaForm.setEmpresas(empresas);
		
		totalimpuesto = total*0.2;
		
		model.addAttribute("total", total);
		model.addAttribute("totalimpuesto", totalimpuesto);
		model.addAttribute("totaltodo", totalimpuesto+total);
		model.addAttribute("articuloCompra", articuloCompra);
		model.addAttribute("empresaForm", empresaForm);
		
		return "compra";
	}
	
	//Finaliza la compra, guarda en base de datos los datos de compra y venta
	@RequestMapping(value = "/finalizar", method = RequestMethod.GET)
	public String finalizar(Model model, @RequestParam Map<String,String> requestParams) {

	
		Compra c = new Compra();
		CompraDAO comDao =  new CompraDAO();
		
		//Guarda datos de la compra en BD
		c.setTarjeta(requestParams.get("numerotarjeta").toString());
		c.setNip(requestParams.get("nip").toString());
		c.setCodigo(requestParams.get("codigo").toString());
		comDao.save(c);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		dateFormat.format(date);
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		timeFormat.format(time);
		
		ArticulosForm articuloCompra = new ArticulosForm();
		articuloCompra.setArticulos(articulosCompra);		
		Empresa empresaSel = null;
		
		for (Empresa empresa : empresas) {
			
			if(requestParams.get("radio"+empresa.getId()) != null){

					empresaSel = empresa;
								
			}
			
		}
		
		System.out.println("emp:**  "+empresaSel);
		VentaDAO ventadao = new VentaDAO();
			
		//	Guarda los datos de la venta
		for (Articulo articulo : articulosCompra) {
					
					
			Venta venta = new Venta();
			venta.setArticulo(articulo);
			venta.setCompra(c);
			venta.setEmpresa(empresaSel);
			venta.setNumero(articulo.getCantidad());
			ventadao.save(venta);
			
				}

		
		
		
		
		model.addAttribute("total", total);
		model.addAttribute("totalimpuesto", totalimpuesto);
		model.addAttribute("totaltodo", totalimpuesto+total);
		model.addAttribute("articuloCompra", articuloCompra);
		model.addAttribute("empresa", empresaSel);
		model.addAttribute("tarjeta",c.getTarjeta());
		model.addAttribute("fecha", dateFormat.format(date));
		model.addAttribute("hora", timeFormat.format(time));		
		return "comprobante";
	}
	

}