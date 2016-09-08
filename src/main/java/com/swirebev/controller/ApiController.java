package com.swirebev.controller;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swirebev.pojo.Employee;
import com.swirebev.service.EmployeeService;
import com.swirebev.utils.JsonResult;

 /**
 * Restful based framework demo
 * @author Chennl
 * @since  jdk1.6
 * @version v1.0
 * @history 2016-08-05 1:50PM
 * @description: @RestController 默认返回 @ResponseBody， 所以@ResponseBody可加可不加
 */


@RestController
@RequestMapping("/api")
public class ApiController {
	 private static final Logger log = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/hello",produces="text/plain;charset=UTF-8")
	public @ResponseBody String SayHello(){
		return "你好！hello";
	}
	
	@RequestMapping(value="/say/{msg}",produces="application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value="msg") String msg){
		return "{\"msg\":\"you say:'" + msg + "'\"}";  
	}
	
	@RequestMapping(value="/employee/{id}",method=RequestMethod.GET/*,produces="application/json;charset=UTF-8"*/)
	public @ResponseBody Employee getEmployee(@PathVariable(value="id") Long id){
		return employeeService.GetEmployeeById(id);	 
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/employee/{id}", method=RequestMethod.POST)
/*	public @ResponseBody String UpdateEmpolyee(@RequestBody String requestJson){
		try {
			requestJson =java.net.URLDecoder.decode(requestJson, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(requestJson);
		return "ok";
	} */
	 public @ResponseBody ResponseEntity<JsonResult> UpdateEmpolyee(HttpEntity<Employee> entity){
	        log.info("get json input from HttpEntity annotation"); 
	        Employee employee= entity.getBody();
	        Boolean result=employeeService.UpdateEmployee(employee);
	        String msg=result?"更新成功！":"更新失败！";
	       
	        ResponseEntity<JsonResult> responseResult = new ResponseEntity<JsonResult>( new JsonResult(result,msg),HttpStatus.OK);
	        return responseResult;
	}
	
	
	
	
	
}
