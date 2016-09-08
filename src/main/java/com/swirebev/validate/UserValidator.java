package com.swirebev.validate;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.swirebev.pojo.User;
 
public class UserValidator implements Validator {
 
    @Override
    public boolean supports(Class<?> clazz) {    
       return User.class.equals(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
       ValidationUtils.rejectIfEmpty(errors, "name", null, "Name Is Empty");
       ValidationUtils.rejectIfEmpty(errors, "userName", null, "Username Is Empty.");
    }
 
}