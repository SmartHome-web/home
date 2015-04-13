<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>用户注册</title>
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
		
		if((/^\w{0}$/.test(f.password1.value))){
			alert("密码不能为空！") ;
			f.password1.focus() ;
			return false ;
		}
		
		with(document.all){
			if(f.password.value!=f.password1.value){
				alert("密码不一致")
				return false;
			}
		}
		return true;
	}
   </script>
  	<body>
  		<center>
  			<c:if test="${!empty error }">
  				<font color="red"><c:out value="${error}"/></font>
  			</c:if>
	    	<form  action="/smartHome/main/userRegister" method="post" onSubmit="return validate(this)">
	    		用户名： <input type="text" name="username" ><br>
	    		<br>
	    		密    码：<input type="password" name="password"><br>
	    		确认密码：<input type="password" name="password1"><br>
	    		
			  	<input type="submit" value ="注册">
	    	</form>
	   	</center>
  	</body>
</html>
