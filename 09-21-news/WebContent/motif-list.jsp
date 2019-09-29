<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.yunhe.entity.*,cn.yunhe.controller.*,java.util.*" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    
    <%
    	/* //从session中获取数据,有就代表不是第一次
    	Object object = session.getAttribute("paging");
    	if(object == null){
    		response.sendRedirect("motifServlet?type=query");
    	} */
    %>
    
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加主题','./motif-add.jsp',600,200)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>主题ID</th>
                                    <th>主题名称</th>
                                    <th>创建时间</th>
                                    <th>状态</th>
                                    <th>操作</th></tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <c:remove var="motifList"/>
    </body>
    <script>
    
    $(function(){
    	getData();
    	function getData(index){
    		$('table tbody').empty();
    		$('.page').empty();
    		var url = null;
    		if(null == index){
    			url = "motifServlet?type=query";
    		}else{
    			url = "motifServlet?type=query&pageIndex="+index;
    		}
    		
    		$.ajax({
        		url:url,
        		type:"post",
        		data:{},
        		success:function(data){
        			var pagingJson = JSON.parse(data);
        			if(null != pagingJson){
        				$.each(pagingJson.list,function(index,motif){
        					$('table tbody').append('<tr><td><input type="checkbox" name="id" value="1" lay-skin="primary"></td><td>'+
        							motif.id+"</td><td>"+motif.motif+"</td><td>"+motif.create_date+"</td><td>"+motif.state+"</td>"+
        							'<td class="td-manage"><a href="motifServlet?type=update&id="'+motif.id+'&state='+motif.state + '" ><i class="layui-icon">&#xe601;</i></a></td></tr>');
        				});
        				
        				if(pagingJson.pageIndex != 1){
        					$('.page').append('<a title="previous" class="prev" href="javascript:;">&lt;&lt;</a>')
        				}
        				for(var index=1;index<=pagingJson.pageTotal;index++){
        					
        					if(pagingJson.pageIndex == index){
        						$('.page').append('<a class="num" href="javascript:;" ><span class="current">'+index+'</span></a>')
        					}else{
        						$('.page').append('<a class="num" href="javascript:;" ><span>'+index+'</span></a>');
        					}
        				}
        				if(pagingJson.pageIndex != pagingJson.pageTotal){
        					$('.page').append('<a title="next" class="next" href="javascript:;">&gt;&gt;</a>')
        				}
        			}
        		}
        	})
    	}
    	$(".page").on("click","a",function(){
    		if("next" == $(this).attr('title')){
    			getData(parseInt($('.current').text())+1);
    		}else if("previous" == $(this).attr('title')){
    			getData($('.current').text()-1);
    		}else{
    			getData($(this).children(0).text());
    		}
    	})
    
    })
    
    
    
    
    
    
    
    
    
    
    
    </script>
</html>