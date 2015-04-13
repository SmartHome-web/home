<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>登录页面</title>
  	</head>
  	<script language="javascript">
	function validate(f){
		if((/^\w{0}$/.test(f.username.value))){
			alert("用户名不能为空！") ;
			f.username.focus() ;
			return false ;
		}
		if((/^\w{0}$/.test(f.password.value))){
			alert("密码不能为空！") ;
			f.password.focus() ;
			return false ;
		}
		return true;
	}
</script>
  	<body>
  		<center>
  		<c:if test="${!empty error }">
  			<font color="red"><c:out value="${error}"/></font>
  		</c:if>
    	<form  action="/smartHome/main/loginCheck" method="post" onSubmit="return validate(this)">
    		 用户名:<input type="text" name="username"><br>
    		 
    		 密    码:    <input type="password" name="password" ><br>
    		
		  	<input type="submit" value ="登陆">
    	</form>
   		</center>
  	</body>
</html>
