package com.swirebev.inteceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swirebev.utils.JsonResult;
import com.swirebev.utils.TokenUtils;

public class ApiSecurityInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log= LoggerFactory.getLogger(ApiSecurityInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//Try to get token string from paramaters
		String token = request.getParameter("token"); 
		String appkey = request.getParameter("appkey");
		// Try to get token from Request header
		if(token==null || token.isEmpty())
			token = request.getHeader("token");
		if(appkey==null || appkey.isEmpty())
			appkey = request.getHeader("appkey");
		
		if(!TokenUtils.validateToken(appkey,token)){
			
			response.setCharacterEncoding("UTF-8");	 
			response.setContentType("text/html;charset=UTF-8");  

			ObjectMapper objectMapper = new ObjectMapper();
			@SuppressWarnings("rawtypes")
			JsonResult result= new JsonResult(false,"you cannot access this URL!");
			String json = objectMapper.writeValueAsString(result);
			response.getWriter().print(json);
			response.setStatus(500);
			return false;
		}
		 
		log.debug("Interceptor preHanle(): true"+ request.getRequestURL().toString());
		return true;
	}
}
