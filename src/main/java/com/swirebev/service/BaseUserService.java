package com.swirebev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swirebev.dao.UserDao;
import com.swirebev.pojo.User;
@Service
public class BaseUserService implements IBaseUserService{
	
	@Autowired
	private UserDao userDao;
	@Override
	public User findByUserName(String userName) {	
		 List<User> list = userDao.find("from com.swirebev.pojo.User u where u.userName='"+userName+"'");
		 if(list.iterator().hasNext())
			 return list.iterator().next();
		return null;
	}

}
