package com.swirebev.dao.hibernate.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swirebev.dao.EmployeeDao;
import com.swirebev.dao.hibernate.GenericDaoImplHibernate;
import com.swirebev.pojo.Employee;
 
@Repository
@Transactional
public class EmployeeDaoImpl extends GenericDaoImplHibernate<Employee> implements EmployeeDao {

}
