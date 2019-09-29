<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <button>展示所有用户信息</button> -->
	<table cellspacing="0" cellpadding="5px" border="1" align="center" width="50%">
		<tr>
			<th>序号</th>
			<th>账号</th>
			<th>密码</th>
		</tr>
	</table>
	<script src="./js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
	/* $(function(){
		$('button').click(function(){
			$.ajax({
				url:"login2Servlet?type=show",
				type:'post',
				data:{},
				dataType:'text',
				success:function(data){
					console.log(data);
					var arr = JSON.parse(data);
					console.log(arr);
					$.each(arr,function(i,e){
						$('table').append("<tr><td>"+e.uid+"</td><td>"+e.uname+"</td><td>"+e.password+"</td></tr>");
					})
				},
				error:function(data){
					
				}
			})
		})
	}) */
	window.onload=function(){
		$.ajax({
			url:"login2Servlet?type=show",
			type:'post',
			data:{},
			dataType:'text',
			success:function(data){
				console.log(data);
				var arr = JSON.parse(data);
				console.log(arr);
				//i 下标 e 对象
				$.each(arr,function(i,e){
					$('table').append("<tr><td>"+e.uid+"</td><td>"+e.uname+"</td><td>"+e.password+"</td></tr>");
				})
			},
			error:function(data){
			
			}
		})
	}
	</script>
</body>
</html>