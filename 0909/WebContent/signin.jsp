<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body><h2>注册</h2>
	<form name="signin" action="login.jsp"  method="post" onsubmit="return check(this);">
		用户名：<input type="text" name="username" id="username"/>
		<br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/>
		<br>
		性&nbsp;&nbsp;&nbsp;别：
		<input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
		<br>
		自我介绍：
		<textarea name="introduction" rows="5" cols="20"></textarea>
		<br>
		<input type="submit" value="注册"/>
	</form>
	<script type="text/javascript">
	function check(signin){
		if(signin.username.value == ""){
			alert("请输入用户名");
			return false;
		}else if(signin.password.value == ""){
			alert("请输入密码");
			return false;
		}else if(signin.sex.value == null){
			alert("请选择性别");
			return false;
		}else if(signin.introduction.value == ""){
			alert("请输入自我介绍");
			return false;
		}else{
			return true;
		}
	}
	</script>
</body>
</html>