<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button>show user infos</button>
	
	<table cellspacing="0" cellpadding="5px" border="1px" align="center" width="50%">
		<tr>
			<th>序号</th>
			<th>账户</th>
			<th>密码</th>
		</tr>
	</table>
	<script src="./js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$('button').click(function(){
				$.ajax({
					url:"getUserInfos",
					type:"post",
					data:{
						"pageIndex":1
					},
					dataType:'text',
					success:function(data){
						var arr = JSON.parse(data);
						console.log(arr);
						$.each(arr,function(i,e){
							$('table').append("<tr><td>"+e.id+"</td><td>"+e.uname+"</td><td>"+e.pwd+"</td></tr>");
						})
					}
				}) 
				
			})
		})
	</script>
</body>
</html>