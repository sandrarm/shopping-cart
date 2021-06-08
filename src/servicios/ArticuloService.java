package servicios;

import clases.ArticuloDAO;
import clases.Articulo;
import java.util.List;

public class ArticuloService {

	
	public List<Articulo> listarArticulos() {
		ArticuloDAO artDao = new ArticuloDAO() ;
		return artDao.findAll();
	}
	
	
}
