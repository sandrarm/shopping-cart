package clases;
// default package



/**
 * Articulo entity. @author MyEclipse Persistence Tools
 */
public class Articulo extends AbstractArticulo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Articulo() {
    }

	/** minimal constructor */
    public Articulo(String nombre, String descripcion, Double precio) {
        super(nombre, descripcion, precio);        
    }
    
    /** full constructor */
    public Articulo(String nombre, String descripcion, Double precio, Integer cantidad, Double total) {
        super(nombre, descripcion, precio, cantidad, total);        
    }
   
}
