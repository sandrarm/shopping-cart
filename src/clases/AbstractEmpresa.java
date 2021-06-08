package clases;
// default package



/**
 * AbstractEmpresa entity provides the base persistence definition of the Empresa entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractEmpresa  implements java.io.Serializable {


    // Fields    

     @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((importe == null) ? 0 : importe.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEmpresa other = (AbstractEmpresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (importe == null) {
			if (other.importe != null)
				return false;
		} else if (!importe.equals(other.importe))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AbstractEmpresa [id=" + id + ", nombre=" + nombre
				+ ", importe=" + importe + "]";
	}

	private Integer id;
     private String nombre;
     private Double importe;


    // Constructors

    /** default constructor */
    public AbstractEmpresa() {
    }

    
    /** full constructor */
    public AbstractEmpresa(String nombre, Double importe) {
        this.nombre = nombre;
        this.importe = importe;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getImporte() {
        return this.importe;
    }
    
    public void setImporte(Double importe) {
        this.importe = importe;
    }
   








}