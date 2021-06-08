package clases;
// default package



/**
 * AbstractCompra entity provides the base persistence definition of the Compra entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCompra  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String tarjeta;
     private String nip;
     private String codigo;


    // Constructors

    /** default constructor */
    public AbstractCompra() {
    }

	/** minimal constructor */
    public AbstractCompra(String tarjeta, String nip) {
        this.tarjeta = tarjeta;
        this.nip = nip;
    }
    
    /** full constructor */
    public AbstractCompra(String tarjeta, String nip, String codigo) {
        this.tarjeta = tarjeta;
        this.nip = nip;
        this.codigo = codigo;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNip() {
        return this.nip;
    }
    
    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

	@Override
	public String toString() {
		return "AbstractCompra [id=" + id + ", tarjeta=" + tarjeta + ", nip="
				+ nip + ", codigo=" + codigo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
		result = prime * result + ((tarjeta == null) ? 0 : tarjeta.hashCode());
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
		AbstractCompra other = (AbstractCompra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		if (tarjeta == null) {
			if (other.tarjeta != null)
				return false;
		} else if (!tarjeta.equals(other.tarjeta))
			return false;
		return true;
	}
   








}