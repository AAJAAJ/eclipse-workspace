<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
	用户名：<input type="text" name="username" id="username">
	<span></span><br>
	密码	：<input type="password" name="pwd" id="pwd">
	<span></span><br>
	<input type="submit" id="submit">
	</form>
	<script src="./js/jquery-3.1.1.js"></script>
	<script >

	$(function() {
		$('#submit').click(function() {
			//获取用户输入的用户名
			var username = $('#username').val();
			console.log(username);
			var pwd = $('#pwd').val();
			console.log(pwd);
			$.ajax({
				url :'login2Servlet?type=submit',
				type :'post',
				data :{
					"username" : username,
					"pwd" : pwd
				},
				dataType:"text",
				success : function(data) {
					//data是Servlet那边写的值
					//alert(data);
					if(data==1){
						window.location.href = "show.jsp";
					}else{
						alert(data);
					}
					//window.location.href = "show.jsp";
				},
				error : function(data) {
					alert(data);
				}
			})
		})
	})
/* 		$(function () {
			$('form').on('blur','#username',function(){
				//获取用户输入的用户名
				var username = $(this).val();
				//将获取的用户名发送到后台 与数据库对比
				$.ajax({
					url:'login2Servlet?type=blur',
					type:'post',
					data:{
						"username":username
					},
					//dataType:'utf-8',
				success:function(data){
					$('#username').next().text(data);
					console.log(data);
					
				},
				error:function(){
					
				}
				})
			}) */
		
	</script>
</body>
</html>