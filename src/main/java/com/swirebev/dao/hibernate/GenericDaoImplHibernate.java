package com.swirebev.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.swirebev.dao.generic.GenericDao;

import java.lang.reflect.ParameterizedType;
@Transactional
public class GenericDaoImplHibernate<T> extends HibernateGenericDao implements GenericDao<T>{
	 protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImplHibernate() {
	        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	    }

	 protected final void setClazz(final Class<T> clazzToSet) {
	        this.entityClass =  clazzToSet ; 
	    }
	protected Class<T> getEntityClass() {
	        return entityClass;
	  } 
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);		
	}
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	@Override
	public void deleteById(Serializable id) {
		getHibernateTemplate().delete(getById(id));
	}
	@Override
	public T getById(Serializable id) {
		return (T)getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String queryString) {
		return (List<T>) getHibernateTemplate().find(queryString);
	}

	 
	

}
