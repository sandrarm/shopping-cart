package clases;
// default package



/**
 * Empresa entity. @author MyEclipse Persistence Tools
 */
public class Empresa extends AbstractEmpresa implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Empresa() {
    }

    
    /** full constructor */
    public Empresa(String nombre, Double importe) {
        super(nombre, importe);        
    }
   
}
