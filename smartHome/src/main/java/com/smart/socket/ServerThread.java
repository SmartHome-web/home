package com.smart.socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import com.smart.domain.Message1;
import com.smart.service.MessageService;

public class ServerThread extends Thread {
	private Socket clientRequest; // 用户连接的通信套接字
	private int recvMsgSize; // Size of received message
	private static final int BUFSIZE = 1024; // Size of receive buffer
	private boolean flag = true;
	MessageService mesS = new MessageService();
	Message1 mes = new Message1();
	//private SendTcpServer send;

	public ServerThread(Socket s) { // serverThread的构造器
		this.clientRequest = s;
		//this.send=new SendTcpServer();
	}

	public void run() { // 线程的执行方法
		while (flag) {
			try {
				SocketAddress clientAddress = clientRequest
						.getRemoteSocketAddress();
				byte[] receiveBuf = new byte[BUFSIZE]; // Receive buffer
				InputStream in = clientRequest.getInputStream();
				OutputStream out = clientRequest.getOutputStream();
				while ((recvMsgSize = in.read(receiveBuf)) != -1) { // 只要客户端在发数据就会返回给客户端数据

					/* @1:打印从客户端接收的帧数据 */
//					System.out.println("---接收到的IP和端口" + clientAddress
//							+ "---接收到的数据"
//							+ new String(receiveBuf, 0, recvMsgSize)
//							+ "---接收到的数据大小"
//							+ new String(receiveBuf, 0, recvMsgSize).length());
					//send.send("111", 2, "33333");
					
					//out.write("6666666666".getBytes());
					String str = new String(receiveBuf, 0, recvMsgSize);
					String str1 = str.substring(10, 13);
					String str2 = str.substring(13, 15);
					System.out.println("温度"+str1);
					System.out.println("湿度"+str2);                                                                                                                                                                                                                                                                                                          
					mes.setTemperature(str1);
					mes.setHumidity(str2);
					mes.setSmog("1");
					mesS.saveMessage(mes);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
