<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>用户注册</title>
  	</head>
  	<script language="javascript">
	function validate(f){
		
		if(!(/^1[3|4|5|8][0-9]{9}$/.test(f.phone.value))){
			alert("电话号码格式不对！") ;
			f.phone.focus() ;
			return false ;
		}
		if((/^\w{0}$/.test(f.phone.value))){
			alert("电话号码不能为空！") ;
			f.phone.focus() ;
			return false ;
		}
		
		if((/^\w{0}$/.test(f.email.value))){
			alert("邮箱不能为空！") ;
			f.email.focus() ;
			return false ;
		}
		if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(f.email.value)){
			alert("请输入格式正确的e-mail地址！");
			f.email.focus();
			return false;
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
	    	<form  action="/smartHome/main/addPersonalInformation" method="post" onSubmit="return validate(this)">
	    		电话号码： <input type="text" name="phone" ><br>
	    		<br>
	    		邮箱：<input type="text" name="email"><br>
	    		
	    		
			  	<input type="submit" value ="添加">
	    	</form>
	   	</center>
  	</body>
</html>
