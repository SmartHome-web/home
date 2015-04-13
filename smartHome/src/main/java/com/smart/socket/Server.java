package com.smart.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//public static void main(String args[]){
	public void startServer(){
		
		
		System.out.println("*****开始执行监听****");
	 	final int RECEIVE_PORT=6000;//该服务器的端口号
	    ServerSocket rServer=null; //ServerSocket的实例
	    Socket request=null; //用户请求的套接字
        Thread receiveThread=null;
	 	try {
		rServer=new ServerSocket(RECEIVE_PORT); //初始化ServerSocket 
	 	while(true){ //等待用户请求
 		System.out.println("*****开始执行****");
		request=rServer.accept(); //接收客户机连接请求
		System.out.println("*****行****");
		receiveThread=new ServerThread(request); //生成serverThread的实例
		receiveThread.start(); //启动serverThread线程 
	 	}
	 	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

