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
	用户名：<input type="text" name="username" id="username"><span></span><br>
	密码	：<input type="password" name="password"id="password"><br>
	邮箱	：<input type="text" name="email"id="email"><br>
	<input type="submit" value="提交">
	</form>
	
	<script src="./js/jquery-3.1.1.js"></script>
	<script >
		$(function () {
			$('form').on('blur','#username',function(){
				//获取用户输入的用户名
				var username = $(this).val();
				console.log(username);
				console.log(1);
				//将获取的用户名发送到后台 与数据库对比
				$.ajax({
					url:'loginServlet',
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
				//根据结果进行提示
			})
		})
	</script>
</body>
</html>