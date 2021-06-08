package clases;
// default package



/**
 * AbstractVenta entity provides the base persistence definition of the Venta entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVenta  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Compra compra;
     private Empresa empresa;
     private Articulo articulo;
     private Integer numero;


    // Constructors

    /** default constructor */
    public AbstractVenta() {
    }

    
    /** full constructor */
    public AbstractVenta(Compra compra, Empresa empresa, Articulo articulo, Integer numero) {
        this.compra = compra;
        this.empresa = empresa;
        this.articulo = articulo;
        this.numero = numero;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Articulo getArticulo() {
        return this.articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }


	@Override
	public String toString() {
		return "AbstractVenta [id=" + id + ", compra=" + compra + ", empresa="
				+ empresa + ", articulo=" + articulo + ", numero=" + numero
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((articulo == null) ? 0 : articulo.hashCode());
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		AbstractVenta other = (AbstractVenta) obj;
		if (articulo == null) {
			if (other.articulo != null)
				return false;
		} else if (!articulo.equals(other.articulo))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
   








}