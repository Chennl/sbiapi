package com.swirebev.controller;

import java.util.ArrayList;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

import com.swirebev.dao.UserDao;
import com.swirebev.pojo.User;
import com.swirebev.validate.UserValidator;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	UserDao userDao;
	@RequestMapping(value="/index", params="demo")
	public String Index(Model model)
	{
		List<String> list= new ArrayList<String>();
		list.add("星期一");
		list.add("Tuesday");
		list.add("Wednesday");
		list.add("Thursday");
		list.add("Friday");
		list.add("星期六");
		list.add("星期日");
		model.addAttribute("days",list);		
		model.addAttribute("msg", "Hello World!");		
		return "index";
	}
	@RequestMapping(value="/login")
	public String Login(Model model)
	{

		
		User user= new User();
		user.setId(0);
		user.setUserName("Mike");
		user.setPassword("123456");
		user.setRemenberMe(true);
		model.addAttribute("loginUser", user);
		return "login";
	}
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String Register(Model model)
	{
		Map<Integer,String> companies= new HashMap<Integer, String>();
		companies.put(3006, "浙江太古");
		companies.put(3007, "江苏太古");
		companies.put(3008, "֣广东太古");
		model.addAttribute("companies",companies);
		
		Map<Integer,String> departments= new HashMap<Integer, String>();
		departments.put(1001, "市场销售部");
		departments.put(1002, "财务部");
		departments.put(1003, "人力资源部");
		departments.put(1004, "信息技术部");
		model.addAttribute("departments",departments);
				
		User user= new User();
		user.setId(0);
		user.setName("Mike");
		user.setUserName("bis\\mike");
		user.setPassword("123456");
		user.setSex(1);
		user.setOnJob(true);
		user.setCompanyId(3008);
		user.setRemenberMe(true);
		user.setHobbies(new String[]{"阅读","旅游","音乐"});
		user.setRemark("新员工入职ְ");
		model.addAttribute("user", user);		
		return "register";
	}
	
	@InitBinder  
	 public void initBinder(DataBinder binder) {  
	  binder.setValidator(new UserValidator());  
	  }  

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String ValidateRegister(@Validated  User user, Errors errors)
	{	
	    if (errors.hasFieldErrors())  
	    	   return "register";  
	    return "submit";  
	}
	
 
	 
}

