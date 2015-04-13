package com.smart.serverSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String args[]){
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
	
	
	
	public void startUp(){
		ServerSocket ss = null;
		Socket s = null;
		String name = "�ͻ���[%s:%s]";
		try {
			 ss = new ServerSocket(6000);
			 System.out.println("������������");
			 while(true){
				 s = ss.accept();
				
				System.out.println(String.format(name, s.getInetAddress().getHostAddress(),s.getPort()));
				PrintWriter in = new PrintWriter(s.getOutputStream(),true);
				in.println("hello,client");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(s!=null)s.close();
				if(ss!=null)ss.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

