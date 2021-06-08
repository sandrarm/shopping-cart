package clases;
// default package

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Empresa entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Empresa
  * @author MyEclipse Persistence Tools 
 */
public class EmpresaDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(EmpresaDAO.class);
		//property constants
	public static final String NOMBRE = "nombre";
	public static final String IMPORTE = "importe";



    
    public void save(Empresa transientInstance) {
        log.debug("saving Empresa instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Empresa persistentInstance) {
        log.debug("deleting Empresa instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Empresa findById( java.lang.Integer id) {
        log.debug("getting Empresa instance with id: " + id);
        try {
            Empresa instance = (Empresa) getSession()
                    .get("Empresa", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Empresa instance) {
        log.debug("finding Empresa instance by example");
        try {
            List results = getSession()
                    .createCriteria("Empresa")
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
      log.debug("finding Empresa instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Empresa as model where model." 
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
	
	public List findByImporte(Object importe
	) {
		return findByProperty(IMPORTE, importe
		);
	}
	

	public List findAll() {
		log.debug("finding all Empresa instances");
		try {
			String queryString = "from Empresa";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Empresa merge(Empresa detachedInstance) {
        log.debug("merging Empresa instance");
        try {
            Empresa result = (Empresa) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Empresa instance) {
        log.debug("attaching dirty Empresa instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Empresa instance) {
        log.debug("attaching clean Empresa instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}