<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<spring:url value="/resources/core/js/jquery-1.11.3.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
 </head>
<body>
  Login
  <form action="./home/login"  method="POST">
    <table>
	     <tr>
	        <td>AppyKey:</td><td><input id="appkey" name="appkey" value="71267312"/></td>
        </tr>
        <tr>
            <td>UserName:</td><td><input id="username" name="username" value="chennl"/></td>
        </tr>
        <tr>
            <td>Password:</td><td><input  type="password" id="password" name="password" value="abcdefg"/></td>
        </tr>
        <tr>
            <td>RememberMe:</td><td><input type="checkbox" id="rememberme" name="rememberme"/></td>
        </tr>
        <tr>
            <td  ><input type="submit" value="登录"/></td>
        
            <td ><c:url value="/home/register" var="regUrl" ></c:url> <a href="${regUrl}">注册</a>  </td>
        </tr>
    </table>
  	</form>
  	
 
 <script type="text/javascript">  
       $(function() {  
           $("#btnGet").click(function() {  
        	  // alert(1);
               $.ajax( {  
                   type : "GET",  
                   url : "../api/employee/8002",  
                   dataType: "json",  
                   success : function(msg) {  
                      // alert(msg.name);  
                       $("#id").val(msg.id);
                       $("#name").val(msg.name);
                       $("#sex").val(msg.sex);
                      // $("#birthday").val(msg.birthday);
                   },
                   error:function(responseData){
                	   alert("in ajax, error: " + responseData.responseText); 
                   }
               
               });  
           }); 
 
      
           
           $("#btnPost").click(function() {  
        	    	  
        	   var jsonString ='{"id":'+$("#id").val()+',"name":"'+$("#name").val()+'","sex":"'+$("#sex").val()+'","remark":null}';
        	   //JSON.stringify(jsonString)
               $.ajax( {  
                   type : "POST",  
                   url : "../api/employee/8002?appkey=71267312&token=${token}",  
                   //dataType: "json", 
                   contentType:"application/json",
                   data: jsonString,
                   success : function(msg) {  

                       if(msg.success)
                   	   {
                   	    alert(msg.message);
                   	   }
                   },
                   error:function(responseMsg){
                	   alert("  in ajax, error: " + responseMsg); 
                   }             
               });  
           });  
       });  
       
       
       
   </script>  
  
   
  	
</body>
</html>