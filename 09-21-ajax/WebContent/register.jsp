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
		用户名:<input type="text" name="uname" id="uname" /><span></span>
		<br />
		密码:<input type="text" name="pwd" id="pwd" /><br />
		重复密码:<input type="text" name="repwd" id="repwd" /><br />
		email:<input type="text" name="email" id="email" /><br />
		<input type="submit" value="注册"/>
	</form>
	
	
	<script src="./js/jquery-3.1.1.js"></script>
	<script>
		$(function(){
			$('form').on('blur','#uname',function(){
				/* //获取用户输入的用户名
				var uname = $(this).val();
				//将获取到的用户名发送到后台,对比数据库中已有的用户名进行判断
				$.ajax({
					url:'userServlet',
					type:'post',
					data:{
						"uname":uname
					},
					success:function(data){
						//$('#uname').next().text(data);
						//console.log(JSON.parse(data)[0].uname);
						var arr = JSON.parse(data);
						$.each(arr,function(){
							console.log(this.uname);
						})
					},
					error:function(){
						
					}
				})
				//根据判断结果进行提示 */
				
				var xmlhttp;
				if (window.XMLHttpRequest)
				  {// code for IE7+, Firefox, Chrome, Opera, Safari
				  xmlhttp=new XMLHttpRequest();
				  }
				else
				  {// code for IE6, IE5
				  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				
				//当响应状态发生改变时就会自动触发该回调函数
				xmlhttp.onreadystatechange = function(){
					
					if(xmlhttp.readyState == 4 && xmlhttp.status==200){
						//获取相应结果
						$('#uname').next().text(xmlhttp.responseText)
					}
				}
				
				//xmlhttp.open("get","userServlet?uname="+$(this).val(),true);
				xmlhttp.open("post","userServlet");
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("uname="+$(this).val()+"&index="+1);
			})
		})
	</script>
</body>
</html>