package com.swirebev.dao.spring;

import java.io.Serializable;
import java.util.List;

import com.swirebev.dao.generic.GenericDao;

public class GenericDaoImplJdbcTemplate<T> extends JdbcTemplateGenericDao implements GenericDao<T>{

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//JdbcDaoSupport类已经有了public final void setDataSource(DataSource dataSource)了 
	
	

}
