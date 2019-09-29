<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="show.jsp" method="post">
		用户名:<input type="text" name="username" id="username" /><span></span>
		<br />
		密码:<input type="text" name="pwd" id="pwd" />
		<br />
		重复密码:<input type="text" name="repwd" id="repwd" /><span></span>
		<br />
		<input type="submit" value="注册"/>
</form>
<script src="./js/jquery-3.1.1.js"></script>
<script>
$(function(){
	$('form').on('blur','#username',function(){
		 //获取用户输入的用户名
		var username = $(this).val();
		//将获取到的用户名发送到后台,对比数据库中已有的用户名进行判断
		$.ajax({
			url:'SigninServlet',
			type:'post',
			data:{
				"username":username
			},
			success:function(data){
				$('#username').next().text(data);
				
			},
			error:function(){
				
			}
		})
		
	})
	
	$('form').on('blur','#repwd',function(){
		 //获取用户输入密码
		var pwd = $('#pwd').val();
		var repwd = $('#repwd').val();
		console.log(pwd);
		console.log(repwd);
		//将获取到的用户名发送到后台,对比数据库中已有的用户名进行判断
		$.ajax({
			url:'SigninServlet',
			type:'post',
			data:{
				"pwd":pwd,
				"repwd":repwd
			},
			success:function(data){
				$('#repwd').next().text(data);
				console.log(data);
			},
			error:function(){
				
			}
		})
		
	})
})
</script>
	

</body>
</html>