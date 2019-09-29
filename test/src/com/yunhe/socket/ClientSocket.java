package com.yunhe.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 创建socket-->连接服务端-->发送数据-->接收数据-->关闭
 */
public class ClientSocket {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String in = null;
			while(true) {
				in=br.readLine();
				bw.write(in);
				bw.write("\n");
				bw.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
