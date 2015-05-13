package com.demo.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.Sell;

/**
 * A data access object (DAO) providing persistence and search support for Sell
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.demo.dao.Sell
 * @author MyEclipse Persistence Tools
 */

public class SellDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SellDAO.class);
	// property constants
	public static final String QUANTITY = "quantity";
	public static final String UNITPRICE = "unitprice";
	public static final String MEMO = "memo";

	public void save(Sell transientInstance) {
		log.debug("saving Sell instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sell persistentInstance) {
		log.debug("deleting Sell instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sell findById(java.lang.Integer id) {
		log.debug("getting Sell instance with id: " + id);
		try {
			Sell instance = (Sell) getSession().get("com.demo.dao.Sell", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sell instance) {
		log.debug("finding Sell instance by example");
		try {
			List results = getSession().createCriteria("com.demo.dao.Sell")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sell instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sell as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByUnitprice(Object unitprice) {
		return findByProperty(UNITPRICE, unitprice);
	}

	public List findByMemo(Object memo) {
		return findByProperty(MEMO, memo);
	}

	public List findAll() {
		log.debug("finding all Sell instances");
		try {
			String queryString = "from Sell";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sell merge(Sell detachedInstance) {
		log.debug("merging Sell instance");
		try {
			Sell result = (Sell) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sell instance) {
		log.debug("attaching dirty Sell instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sell instance) {
		log.debug("attaching clean Sell instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}