<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<spring:url value="/resources/core/js/jquery-1.11.3.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
 </head>
<body>
 <c:out value="<name> Tom</name>" escapeXml="true" default="default"></c:out><br>
 <c:out value="<name> Tom</name>" escapeXml="false" default="default"></c:out><br>
 <table>
 <tr>
 	<td>A</td>
 	<td>所在位置，即索引</td>
 	<td>总共已迭代的次数</td>
 	<td>是否为第一个位置</td>
 	<td>是否为最后一个位置</td>
 	<td>是否为周末</td>
 	</tr>

  <c:forEach items="${days}" var="day" varStatus="s">
  <tr>
  	<td><c:out value="${day}"></c:out></td>
  	<td><c:out value="${s.index}" /></td>
  	<td><c:out value="${s.count}" /></td>
  	<td><c:out value="${s.first}" /></td>
  	<td><c:out value="${s.last}" /></td>
  	<td>
  	<c:choose > 
  		<c:when test="${day =='星期六'}">
  		 是
		</c:when>
  		<c:when test="${day =='星期日'}">
		是
		</c:when>
  		<c:otherwise> 否 </c:otherwise>
  	</c:choose>
  	</td>
  </tr> 
  </c:forEach>
   </table>
  <br>
  <c:out value="${msg}"></c:out><br>
  
  <c:url value="/home/login" var="url" scope="session">  
  </c:url>  
  <c:url value="/home/register" var="regUrl" scope="session" ></c:url>
  <a href="${url}">登录</a> <br><a href="${regUrl}">注册</a> 
  
  

  
</body>
</html>