<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 
<title>用户注册</title>
</head>
<body>
 <form:form action="register" commandName="user" method="POST">
    <table>
        <tr>
            <td>Name:</td><td><form:input path="name"/></td>
        </tr>
         <tr>
            <td>UserName:</td><td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Sex:</td><td>
				<form:radiobutton path="sex" value="1"/>男
        		<form:radiobutton path="sex" value=""/>女</td>
        </tr>
        <tr>
            <td>Password:</td><td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>company:</td><td><form:select  path="companyId" items="${companies}"/></td>
        </tr>
         <tr>
            <td>department:</td><td>
	            <form:select  path="departmentId">
	             <option>请选择</option>
	             <form:options items="${departments}"/> 
	            </form:select>
            </td>
        </tr>
        
  
        
        <tr>
            <td>Hobbies:</td><td>
            	<form:checkbox path="hobbies" value="旅游"/>旅游
		        <form:checkbox path="hobbies" value="阅读"/>阅读
		        <form:checkbox path="hobbies" value="运动"/>运动
		        <form:checkbox path="hobbies" value="音乐"/>音乐<br/>
			</td>
        </tr>
        <tr>
            <td>OnJob:</td><td><form:checkbox   path="onJob"  /></td>
        </tr>
        <tr>
            <td>remark:</td><td><form:textarea   path="remark"  /></td>
        </tr>
        <tr>
            <td>所有错误信息:</td>
            <td><form:errors path="*"/></td>
        </tr>
        <tr>
            <td>Name的错误信息:</td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>