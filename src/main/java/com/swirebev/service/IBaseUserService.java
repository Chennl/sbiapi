package com.swirebev.service;

import com.swirebev.pojo.User;

public interface IBaseUserService {
  public User findByUserName(String userName);
}
