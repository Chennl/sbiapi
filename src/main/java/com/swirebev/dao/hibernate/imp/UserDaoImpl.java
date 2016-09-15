package com.swirebev.dao.hibernate.imp;

import org.springframework.stereotype.Repository;

import com.swirebev.dao.UserDao;
import com.swirebev.dao.hibernate.GenericDaoImplHibernate;
import com.swirebev.pojo.User;
@Repository
public class UserDaoImpl extends GenericDaoImplHibernate<User> implements UserDao {

}


