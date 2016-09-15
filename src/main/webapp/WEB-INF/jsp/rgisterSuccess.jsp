<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <spring:url value="/resources/core/js/jquery-1.11.3.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
<c:url value="home/login" var="loginurl"/>
<title>用户注册</title>

</head>
<body>

  用户注册成功！
  系统  <span id="span_timer"><b>10</b></span>秒后自动跳转到 登录页面。
  
   如果您的浏览器没有自动跳转，<a href="${loginurl}">请点击这里</a>
 
 <script language=javascript>
(function() {
    var total = 10; // 倒计时
    var span_timer = document.getElementById("span_timer");
    span_timer.innerHTML = total;
    var timer = setInterval(function() {
        if (total <= 0) {
            location.href = "${loginurl}"; // 跳转
            clearInterval(timer);
            timer = 0;
        } else span_timer.innerHTML = --total;
    }, 1000);
})();


 
</script>
</body>
</html>