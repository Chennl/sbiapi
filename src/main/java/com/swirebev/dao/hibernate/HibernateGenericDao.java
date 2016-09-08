package com.swirebev.dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class HibernateGenericDao extends HibernateDaoSupport{
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
