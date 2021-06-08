package clases;
// default package

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Articulo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Articulo
  * @author MyEclipse Persistence Tools 
 */
public class ArticuloDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ArticuloDAO.class);
		//property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String PRECIO = "precio";
	public static final String CANTIDAD = "cantidad";
	public static final String TOTAL = "total";



    
    public void save(Articulo transientInstance) {
        log.debug("saving Articulo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Articulo persistentInstance) {
        log.debug("deleting Articulo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Articulo findById( java.lang.Integer id) {
        log.debug("getting Articulo instance with id: " + id);
        try {
            Articulo instance = (Articulo) getSession()
                    .get("Articulo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Articulo instance) {
        log.debug("finding Articulo instance by example");
        try {
            List results = getSession()
                    .createCriteria("Articulo")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Articulo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Articulo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNombre(Object nombre
	) {
		return findByProperty(NOMBRE, nombre
		);
	}
	
	public List findByDescripcion(Object descripcion
	) {
		return findByProperty(DESCRIPCION, descripcion
		);
	}
	
	public List findByPrecio(Object precio
	) {
		return findByProperty(PRECIO, precio
		);
	}
	
	public List findByCantidad(Object cantidad
	) {
		return findByProperty(CANTIDAD, cantidad
		);
	}
	
	public List findByTotal(Object total
	) {
		return findByProperty(TOTAL, total
		);
	}
	

	public List findAll() {
		log.debug("finding all Articulo instances");
		try {
			String queryString = "from Articulo";
	        Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Articulo merge(Articulo detachedInstance) {
        log.debug("merging Articulo instance");
        try {
            Articulo result = (Articulo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Articulo instance) {
        log.debug("attaching dirty Articulo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Articulo instance) {
        log.debug("attaching clean Articulo instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}