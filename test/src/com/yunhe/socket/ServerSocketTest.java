package com.yunhe.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端
 * 初始化socket-->绑定监听端口--->设置监听队列-->等待与客户端连接-->接收数据-->反馈数据-->关闭
 */
public class ServerSocketTest {
	
	public static void main(String[] args) {
		try {
			//初始化socket并绑定端口
			ServerSocket serverSocket = new ServerSocket(9999);
			//创建线程池
			ExecutorService executorService = Executors.newFixedThreadPool(100);
			while(true) {
				/*
				 * //等待客户端连接 final Socket socket = serverSocket.accept();
				 * 
				 * new Thread(new Runnable() {
				 * 
				 * @Override public void run() { BufferedReader br; try { br = new
				 * BufferedReader(new InputStreamReader(socket.getInputStream())); String str =
				 * null; while((str=br.readLine())!=null) { System.out.println(str); } } catch
				 * (IOException e1) { e1.printStackTrace(); } } }).start();;
				 */
				
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
	}
}
