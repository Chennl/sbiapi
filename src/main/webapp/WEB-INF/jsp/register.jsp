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
            <td>Name:</td><td><form:input path="nickName"/></td>
        </tr>
         <tr>
            <td>UserName:</td><td><form:input path="userName"/></td>
        </tr>
         <tr>
          <td>性别:</td><td>
           <form:select  path="sex">
            <option>请选择</option>
            <form:options items="${sexs}"/> 
           </form:select>
          </td>
        </tr>
        <tr>
            <td>状态:</td><td>
				<form:radiobutton path="status" value="1"/>正常
        		<form:radiobutton path="status" value="0"/>禁止</td>
        </tr>
        <tr>
            <td>Password:</td><td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>company:</td><td><form:select  path="companyCode" items="${companies}"/></td>
        </tr>

        <tr>
            <td>remark:</td><td><form:textarea   path="remark"  /></td>
        </tr>
        <tr>
            <td>所有错误信息:</td>
            <td><form:errors path="*"/></td>
        </tr>
        <tr>
            <td>UserName的错误信息:</td>
            <td><form:errors path="userName"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>