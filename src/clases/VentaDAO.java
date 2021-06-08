package clases;
// default package

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Venta entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Venta
  * @author MyEclipse Persistence Tools 
 */
public class VentaDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(VentaDAO.class);
		//property constants
	public static final String NUMERO = "numero";



    
    public void save(Venta transientInstance) {
        log.debug("saving Venta instance");
        
        
        Transaction tx = null;
   	 Session s = getSession();
   	 
       try {
        
       	tx = s.beginTransaction();
       	s.save(transientInstance);
                      
           tx.commit();
           log.debug("save successful");
           
           
       } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
       finally {
           s.close();
       }

    }
    
	public void delete(Venta persistentInstance) {
        log.debug("deleting Venta instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Venta findById( java.lang.Integer id) {
        log.debug("getting Venta instance with id: " + id);
        try {
            Venta instance = (Venta) getSession()
                    .get("Venta", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Venta instance) {
        log.debug("finding Venta instance by example");
        try {
            List results = getSession()
                    .createCriteria("Venta")
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
      log.debug("finding Venta instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Venta as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNumero(Object numero
	) {
		return findByProperty(NUMERO, numero
		);
	}
	

	public List findAll() {
		log.debug("finding all Venta instances");
		try {
			String queryString = "from Venta";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Venta merge(Venta detachedInstance) {
        log.debug("merging Venta instance");
        try {
            Venta result = (Venta) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Venta instance) {
        log.debug("attaching dirty Venta instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Venta instance) {
        log.debug("attaching clean Venta instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}