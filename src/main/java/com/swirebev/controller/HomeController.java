package com.swirebev.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

import com.swirebev.pojo.AuthenToken;
import com.swirebev.pojo.User;
import com.swirebev.service.IBaseUserService;
import com.swirebev.utils.TokenUtils;
import com.swirebev.validate.UserValidator;
import com.swirebev.utils.Constants;

@Controller
@RequestMapping("/home")
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	 @Autowired
	 private IBaseUserService baseUserService;
	@RequestMapping(value={"/","/index"})//, params="demo")
	public String Index(@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent,
			HttpServletResponse response,Model model)
	{
		List<String> list= new ArrayList<String>();
		list.add("星期一");
		list.add("星期二");
		list.add("Wednesday");
		list.add("Thursday");
		list.add("Friday");
		list.add("星期六");
		list.add("星期日");
		model.addAttribute("days",list);		
		model.addAttribute("msg", "Hello World!User-Agent:"+userAgent);		
		return "index";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String Login(Model model)
	{
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String checkLogin(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String appKey=request.getParameter("appkey");
		String rememberme=request.getParameter("rememberme");		
		//检查用户正确性
		User user = baseUserService.findByUserName(userName);
		if(null!= user){
			//validate password
			if(password.equals(""))password="";			
			AuthenToken authenToken= new AuthenToken();
			authenToken.setUserId(0);
			authenToken.setNickName(user.getNickName());
			authenToken.setSessionKey(TokenUtils.generateToken(appKey));
			Calendar cal= Calendar.getInstance();
			authenToken.setLoginTime(cal.getTime());
			HttpSession session=request.getSession();
			session.setAttribute(Constants.AUTHEN_TOKEN, authenToken);
			
			int cookieAge=60*60*24*1;//保留1天
			if(null==rememberme)cookieAge=60;
			Cookie cookie = new Cookie("SESSIONKEY",authenToken.getSessionKey());  
			cookie.setMaxAge(cookieAge); 
			response.addCookie(cookie); 
			cookie = new Cookie("APPKEY",appKey);  
			cookie.setMaxAge(cookieAge); 
			response.addCookie(cookie); 
			cookie = new Cookie("UserId",String.valueOf(authenToken.getUserId()));  
			cookie.setMaxAge(cookieAge); 
			response.addCookie(cookie); 
			log.debug("Success to Login!");
			
		}else
		{
			log.debug("Fail to login!");
			Login(null);
		}			
		return "redirect:/home/index";  
	}
	
	@RequestMapping(value="/logout")
	public String loginOut(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.removeAttribute(Constants.AUTHEN_TOKEN);
		return Login(model);
	}
 
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public String Register(Model model)
	{
		Map<Integer,String> companies= new HashMap<Integer, String>();
		companies.put(3006, "浙江太古");
		companies.put(3007, "江苏太古");
		companies.put(3008, "֣广东太古");
		model.addAttribute("companies",companies);
		
		Map<String,String> sexs= new HashMap<String, String>();
		sexs.put("男", "男");
		sexs.put("女", "女");
		model.addAttribute("sexs",sexs);
				
		User user= new User();
		user.setId(0);
		user.setNickName("Jef");
		user.setUserName("Jeffrey");
		user.setPassword("123456");
		user.setSex("男");
		user.setCompanyCode(3006);
		user.setRemark("新员工入职ְ"); 
		model.addAttribute("user", user);		
		return "register";
	}
	
	@InitBinder  
	 public void initBinder(DataBinder binder) {  
	  binder.setValidator(new UserValidator());  
	  }  

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String ValidateRegister(@Validated User user, Errors errors)
	{	
	    if (errors.hasFieldErrors())  
	    	   return "register";  
	    return "rgisterSuccess";  
	}
	
 
	 
}

