package com.swirebev.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
 

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {
	 private int openingTime;
	 private int closingTime;
	 private String mappingURL;
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public int getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
	public String getMappingURL() {
		return mappingURL;
	}
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
	 
 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
	
	 String url = request.getRequestURI().toString();
	 if(mappingURL == null || url.matches(mappingURL) ) 
	 {
		 Calendar  cal = Calendar.getInstance();
		 cal.setTime(new Date());
		 int hour = cal.get(Calendar.HOUR_OF_DAY);
		 if(hour < openingTime && hour >closingTime)
		 {
			  request.setAttribute("msg", "注册开放时间：9：00-12：00");  
			  request.getRequestDispatcher("/msg.jsp").forward(request, response);  
			  return false;  
		 }
	 }
	 return true;
	 	 
 }
 
}
