<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cn.yunhe.entity.*,cn.yunhe.controller.*,java.util.*"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>主题管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<%
	MotifController motifController = new MotifController();
	List<Motif> motifList = motifController.queryMotifList();
	session.setAttribute("motifList", motifList);
	
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取数据
		String type = request.getParameter("type");
		
%>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			onclick="location.reload()" title="刷新"> <i
			class="layui-icon layui-icon-refresh" style="line-height: 30px"></i></a>
	</div>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-body ">
						<form class="layui-form layui-col-space5">
							<div class="layui-inline layui-show-xs-block">
								<input class="layui-input" autocomplete="off" placeholder="开始日"
									name="start" id="start">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<input class="layui-input" autocomplete="off" placeholder="截止日"
									name="end" id="end">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="username" placeholder="请输入用户名"
									autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<button class="layui-btn" lay-submit="" lay-filter="sreach">
									<i class="layui-icon">&#xe615;</i>
								</button>
							</div>
						</form>
					</div>
					<div class="layui-card-header">
						<button class="layui-btn layui-btn-danger" onclick="delAll()">
							<i class="layui-icon"></i>批量删除
						</button>
						<button class="layui-btn"
							onclick="xadmin.open('添加主题','./motif-add.jsp',600,200)">
							<i class="layui-icon"></i>添加
						</button>
					</div>
					<div class="layui-card-body layui-table-body layui-table-main">
						<table class="layui-table layui-form">
							<thead>
								<tr>
									<th><input type="checkbox" lay-filter="checkall" name=""
										lay-skin="primary"></th>
									<th>主题ID</th>
									<th>主题名称</th>
									<th>创建时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty motifList }">
									<p style="color: gray; text-align: center;">网络请求异常</p>
								</c:if>
								<c:if test="${not empty motifList }">
									<c:forEach items="${motifList }" var="motif">
										<tr>
											<td><input type="checkbox" name="id" value="${motif.id }"
												lay-skin="primary"></td>
											<td>${motif.id }</td>
											<td>${motif.motif }</td>
											<td>${motif.create_date }</td>
											<td class="td-status">
											<span
												class="layui-btn layui-btn-normal layui-btn-mini">${motif.state==0?"正常":"禁用" }</span></td>
											<td class="td-manage">
											<a
												onclick="member_stop(this,${motif.id })" href="javascript:;"
												title='${motif.state==0?"禁用":"启用"}'> <i id="jinyong" class="layui-icon">${motif.state==0?"&#xe62f":"&#xe601"}</i>
											</a>  
											<a title="编辑"
												onclick="xadmin.open('编辑','member-edit.html',600,400)"
												href="javascript:;"> <i class="layui-icon">&#xe642;</i>
											</a> 
											<a
												onclick="xadmin.open('修改密码','member-password.html',600,400)"
												title="修改密码" href="javascript:;"> <i class="layui-icon">&#xe631;</i>
											</a>
											<a title="删除" onclick="member_del(this,'${motif.id }')" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a>
											</td>
										</tr>
									</c:forEach>
								</c:if>

							</tbody>
						</table>
					</div>
					<div class="layui-card-body ">
						<div class="page">
							<div>
								<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a>
								<span class="current">2</span> <a class="num" href="">3</a> <a
									class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="js/jquery.min.js"></script>
<script>
	layui.use([ 'laydate', 'form' ], function() {
		var laydate = layui.laydate;
		var form = layui.form;
		success();
		// 监听全选
		form.on('checkbox(checkall)', function(data) {

			if (data.elem.checked) {
				$('tbody input').prop('checked', true);
			} else {
				$('tbody input').prop('checked', false);
			}
			form.render('checkbox');
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#start' //指定元素
		});

		//执行一个laydate实例
		laydate.render({
			elem : '#end' //指定元素
		});

	});

	/*用户-停用*/
	function member_stop(obj, id) {
		layer.confirm('确认要'+$(obj).attr('title')+'吗？', function(index) {
			if ("禁用" == ($(obj).attr('title'))) {
				$.ajax({
					url:'motif-controller.jsp',
					type:'post',
					data:{
						"type":"Prohibit",
						"state":1,
						"id":id
						
					},
					success:function(data){
						layer.msg('已停用!',{icon: 6,time: 1000});
						$('#jinyong').html("&#xe601");
					},
					error:function(){
						layer.msg('停用失败!',{icon: 5,time: 1000});
					}
				})
			} else {
				$.ajax({
					url:'motif-controller.jsp',
					type:'post',
					data:{
						"type":"Prohibit",
						"state":0,
						"id":id
					},
					success:function(data){
						layer.msg('已启用!',{icon: 6,time: 1000});
						$('#jinyong').html("&#xe601");
					},
					error:function(){
						layer.msg('启用失败!',{icon: 5,time: 1000});
					}
				})
			}
		});
	}

	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发异步删除数据
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		location.href='motif-controller.jsp?type=del&id='+id
		});
	}
//批量删除
	function delAll(argument) {
		var ids = [];
		// 获取选中的id 
		$('tbody input').each(function(index, el) {
			if ($(this).prop('checked')) {
				ids.push($(this).val())
			}
		});

		layer.confirm('确认要删除吗？' + ids.toString(), function(index) {
			
		location.href='motif-controller.jsp?type=delall&id='+ids;
		});
	}
	
	function success(){
		if(<%=type %> == 'add'){
			layer.msg('已添加!',{icon: 6,time: 100000});
		}
		if(<%=type %> == 'del'){
			layer.msg('已删除!',{icon:1,time: 100000});
		}
		if(<%=type %> == 'stop'){
			layer.msg('已停用!',{icon: 5,time: 100000});
		}
		if(<%=type %> == 'start'){
			layer.msg('已启用!',{icon: 5,time: 100000});
		}
	}
	
	
	
</script>
</html>