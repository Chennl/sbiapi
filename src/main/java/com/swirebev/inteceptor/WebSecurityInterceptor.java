/**
 * 
 */
package com.swirebev.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

 
import com.swirebev.utils.Constants;


 

/**
 * @author Chennl
 *
 */
public class WebSecurityInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log= LoggerFactory.getLogger(WebSecurityInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		Object obj=request.getSession().getAttribute(Constants.AUTHEN_TOKEN); 
		//User loginUser =(User) request.getSession().getAttribute(Constants.LOGIN_USER);
		if(obj==null ){
			request.getRequestDispatcher("/home/login").forward(request, response);  
			response.setStatus(500);
			return false;		 
		}
		log.debug("AccessTokenCheckingInterceptor preHanle(): "+ request.getRequestURL().toString());
		return true;
	}

}
