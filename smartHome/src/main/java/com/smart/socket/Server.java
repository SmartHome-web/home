package com.smart.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//public static void main(String args[]){
	public void startServer(){
		
		
		System.out.println("*****��ʼִ�м���****");
	 	final int RECEIVE_PORT=6000;//�÷������Ķ˿ں�
	    ServerSocket rServer=null; //ServerSocket��ʵ��
	    Socket request=null; //�û�������׽���
        Thread receiveThread=null;
	 	try {
		rServer=new ServerSocket(RECEIVE_PORT); //��ʼ��ServerSocket 
	 	while(true){ //�ȴ��û�����
 		System.out.println("*****��ʼִ��****");
		request=rServer.accept(); //���տͻ�����������
		System.out.println("*****��****");
		receiveThread=new ServerThread(request); //����serverThread��ʵ��
		receiveThread.start(); //����serverThread�߳� 
	 	}
	 	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

