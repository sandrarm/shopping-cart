package clases;
// default package



/**
 * Compra entity. @author MyEclipse Persistence Tools
 */
public class Compra extends AbstractCompra implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Compra() {
    }

	/** minimal constructor */
    public Compra(String tarjeta, String nip) {
        super(tarjeta, nip);        
    }
    
    /** full constructor */
    public Compra(String tarjeta, String nip, String codigo) {
        super(tarjeta, nip, codigo);        
    }
   
}
