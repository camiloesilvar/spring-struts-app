package org.csr.back.model.data.dao.impl;

import java.util.List;

import org.csr.back.model.data.dao.VilleDao;
import org.csr.back.model.data.entity.Ville;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "villeDao")
public class VilleDaoImpl implements VilleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Ville> findAll() {
		return getCurrentSession().createQuery("from Ville").list();
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
