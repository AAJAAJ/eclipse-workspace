<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="SigninServlet?type=submit" method="post">
		用户名:<input type="text" name="username" id="username" /><span></span>
		<br />
		<br />
		密&nbsp;&nbsp;&nbsp;码:<input type="text" name="password" id="password" /><span></span>
		<br />
		<br />
		</form>
		<input type="button" id="goback" onclick="submit()" value="注册提交"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id="goback" onclick="goback()" value="返回"/>
		
<script src="./js/jquery-3.1.1.js"></script>
<script>
function goback(){
	location.href='login.jsp'
}
function submit(){
	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		url:'SigninServlet',
		type:'post',
		data:{
			"password":password,
			"username":username,
			"type":"submit"
		},
		success:function(data){
			$('#username').next().text(data);
			$('#password').next().text(data);
			console.log(data);
			if(data == 1){
				window.location.href='login.jsp';
			}
		}
	})
}
$(function(){
	$('form').on('blur','#username',function(){
		 //获取用户输入的用户名
		var username = $(this).val();
		//将获取到的用户名发送到后台,对比数据库中已有的用户名进行判断
		$.ajax({
			url:'SigninServlet',
			type:'post',
			data:{
				"username":username,
				"type":"namejudge"
			},
			success:function(data){
				$('#username').next().text(data);
				
			}
		})
		
	})
	$('form').on('blur','#password',function(){
		 //获取用户输入的用户名
		var password = $(this).val();
		if (password == "") {
			$('#password').next().text("必须填写！");
		}
	})
})
</script>
	

</body>
</html>