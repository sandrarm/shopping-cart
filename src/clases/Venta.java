package clases;
// default package



/**
 * Venta entity. @author MyEclipse Persistence Tools
 */
public class Venta extends AbstractVenta implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Venta() {
    }

    
    /** full constructor */
    public Venta(Compra compra, Empresa empresa, Articulo articulo, Integer numero) {
        super(compra, empresa, articulo, numero);        
    }
   
}
