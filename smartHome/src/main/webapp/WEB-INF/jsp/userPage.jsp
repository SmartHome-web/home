<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
   
    
    <title>学生页面</title>
    
  </head>
  
 	<body>
 	
		<center>
			 ${user2.getUsername()}
			 
			<h3><font color="red">登录成功！</font></h3>
			<a href="/smartHome/main/toAddPersonalInformation">完善个人信息</a><br>
			<a href="/smartHome/main/openThread">开启监听</a>
		</center>
		
	</body>
</html>
