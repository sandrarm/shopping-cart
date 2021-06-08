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
import org.springframework.transaction.annotation.Transactional;

/**
 	* A data access object (DAO) providing persistence and search support for Compra entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Compra
  * @author MyEclipse Persistence Tools 
 */
public class CompraDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CompraDAO.class);
		//property constants
	public static final String TARJETA = "tarjeta";
	public static final String NIP = "nip";
	public static final String CODIGO = "codigo";



    @Transactional
    public void save(Compra transientInstance) {
    	 log.debug("saving Compra instance");
    	 System.out.println("saving Compra instance");
        
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
    
	public void delete(Compra persistentInstance) {
        log.debug("deleting Compra instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Compra findById( java.lang.Integer id) {
        log.debug("getting Compra instance with id: " + id);
        try {
            Compra instance = (Compra) getSession()
                    .get("Compra", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Compra instance) {
        log.debug("finding Compra instance by example");
        try {
            List results = getSession()
                    .createCriteria("Compra")
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
      log.debug("finding Compra instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Compra as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTarjeta(Object tarjeta
	) {
		return findByProperty(TARJETA, tarjeta
		);
	}
	
	public List findByNip(Object nip
	) {
		return findByProperty(NIP, nip
		);
	}
	
	public List findByCodigo(Object codigo
	) {
		return findByProperty(CODIGO, codigo
		);
	}
	

	public List findAll() {
		log.debug("finding all Compra instances");
		try {
			String queryString = "from Compra";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Compra merge(Compra detachedInstance) {
        log.debug("merging Compra instance");
        try {
            Compra result = (Compra) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Compra instance) {
        log.debug("attaching dirty Compra instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Compra instance) {
        log.debug("attaching clean Compra instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}