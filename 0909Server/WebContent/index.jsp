<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.Socket"%>
<%@page import="java.util.concurrent.Executors"%>
<%@page import="java.util.concurrent.ExecutorService"%>
<%@page import="java.net.ServerSocket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>服务端</title>
</head>
<body>
	<h1>服务端</h1>
	<%
	try {
		//初始化socket并绑定端口
		ServerSocket serverSocket = new ServerSocket(9999);
		//创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		
		while(true) {
			final Socket socket = serverSocket.accept();
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					BufferedReader br;
					try {
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String str = null;
						while((str=br.readLine())!=null) { System.out.println(str); }
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			};
			executorService.submit(runnable);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	%>
</body>
</html>