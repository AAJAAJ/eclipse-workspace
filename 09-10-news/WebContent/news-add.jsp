<%@page import="cn.yunhe.entity.Subject"%>
<%@page import="java.util.List"%>
<%@page import="cn.yunhe.control.SubjectControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>添加新闻</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" >
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>新闻标题</label>
                        <div class="layui-input-inline">
                            <input type="text" id="title" name="title" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>新闻内容</label>
                        <div class="layui-input-inline">
                            <input type="text" id="content" name="content" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>所属主题</label>
                        <div class="layui-input-inline">
                        <%
                        SubjectControl sc = new SubjectControl();
                        List<Subject> list = sc.selectList();
                        		session.setAttribute("list", list);
                        %>
                        <c:forEach items="${list }" var="ls">
                            <input type="radio" id="${ls.sid }" value="${ls.sid }" name="${ls.sid }" required="" lay-verify="nikename" autocomplete="off" class="layui-input">${ls.title }<br>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="" >增加</button></div>
                </form>
            </div>
        </div>
    </body>
<script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
             
                //监听提交
                form.on('submit(add)',
                		function(data) {
                    console.log(data.field.subject);
                    location.href = "newsControl.jsp?type=addNews&title="+data.field.title+"&content="+data.field.content
                    		+"&id="+data.field.id;
                    //关闭当前frame
                    xadmin.close();
                    // 可以对父窗口进行刷新 
                    xadmin.father_reload();
                    return false;
                });
            });</script>
</html>