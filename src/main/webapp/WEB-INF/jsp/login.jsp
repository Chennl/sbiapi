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
  <form:form action="login.do" commandName="loginUser" method="POST">
    <table>
        <tr>
            <td>UserName:</td><td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td>Password:</td><td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>RemenberMe:</td><td><form:checkbox path="remenberMe"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
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
                	   consoleDebug("  in ajax, error: " + responseData.responseText); 
                   }
               
               });  
           }); 
 
           $("#btnLogin").click(function() {         	   
        	   //var jsonString ='{"id":"'+$("#id").val()+'","name":"'+$("#name").val()+'","sex":"'+$("#sex").val()+'" }';  
        	   var jsonString ='{"employeeNo": "2101596", "password": "sw1234.", "deviceUUID": "2763521f-82b6-4d4b-893d-33542e5777c3", "appCode":"Portal", "version": "1.0.7", "build": 2806, "os": "iOS", "osVer":"8.12", "deviceBrand": "123", "deviceModel": "1324423", "deviceResolution": "7543"}';
        	   //JSON.stringify(jsonString)
               $.ajax( {  
                   type : "POST",  
                   url : "http://192.168.59.145:8080/SBI/v1/loginWithEmployeeNo",  
                   //dataType: "json", 
                   contentType:"application/json",
                   data: jsonString,
                   success : function(msg) {  
                      objJson = $.parseJSON(msg);
                      if(objJson.status==200)
                    	  {
                    	    var url='https://mcmocuat.swirebev.com:8000/CWF30/Loading.aspx?token='+objJson.authInfo.token+'&routeCode=0081&empCode=2101695&deviceUUID=&os=IOS&osVersion=6.1&requestDate=201608101109&processType=MOD&taskId=0021FD14-99E3-4A30-935D-569834910DA5&accessSource=SFA&outletNo=0514616109';
                    	    window.location = url;
                    	  }
                      // alert(objJson.authInfo.token); 
                      else
                    	  alert(objJson.message);
                   },
                   error:function(responseMsg){
                	   alert("  in ajax, error: " + responseMsg); 
                   }             
               });  
           }); 
           
           $("#btnPost").click(function() {  
        	           	  
        	   var jsonString ='{"id":'+$("#id").val()+',"name":"'+$("#name").val()+'","sex":"'+$("#sex").val()+'","remark":null}';
        	   //JSON.stringify(jsonString)
               $.ajax( {  
                   type : "POST",  
                   url : "../api/employee/8002",  
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
  
   
  	<form>
  	 <table>
        <tr>
            <td>Employee ID:</td><td><input id="id" name="id" value=2100968 /></td>
        </tr>
        <tr>
            <td>Name:</td><td><input id="name" name="name"/></td>
        </tr>
        <tr>
            <td>Password:</td><td><input  type="password" id="password" name="password"/></td>
        </tr>
        <tr>
            <td>sex:</td><td><input id="sex"  name="sex"/></td>
        </tr>
         <tr>
            <td>birthday:</td><td><input id="birthday"  name="birthday"/></td>
        </tr>
        <tr>
            <td colspan="2"><input id="btnGet" type="button" value="获取员工信息" /></td>
             
        </tr>
         <tr>
            <td colspan="2">	<input id="btnPost" type="button" value="提交员工信息" /></td>
        </tr>  
      
         <tr>
 			<td colspan="2">	<input id="responseMsg"  /></td>
        </tr> 
    </table>
  	</form>
</body>
</html>