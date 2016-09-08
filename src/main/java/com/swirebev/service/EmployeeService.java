package com.swirebev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.swirebev.dao.EmployeeDao;
import com.swirebev.pojo.Employee;
@Service
public class EmployeeService {
	 private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	 
	@Autowired
	private EmployeeDao employeeDao;
	public Employee GetEmployeeById(Long id){
		return employeeDao.getById(id);
	}
	public Boolean UpdateEmployee(Employee employee)
	{
		try{			
			Employee entity = employeeDao.getById(employee.getId());
			if(entity == null ){
				log.debug("Employee with id="+employee.getId()+" is not found");
				return false;
			}
			entity.setName(employee.getName());
			employeeDao.update(entity);
			return true;
		}catch(Exception e)
		{
			log.error("EmployeeService occurs error during execute employee update: "+e.getMessage());
			return false;
		}
	}
}
