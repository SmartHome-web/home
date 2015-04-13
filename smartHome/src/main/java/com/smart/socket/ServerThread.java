package com.smart.socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import com.smart.domain.Message1;
import com.smart.service.MessageService;

public class ServerThread extends Thread {
	private Socket clientRequest; // �û����ӵ�ͨ���׽���
	private int recvMsgSize; // Size of received message
	private static final int BUFSIZE = 1024; // Size of receive buffer
	private boolean flag = true;
	MessageService mesS = new MessageService();
	Message1 mes = new Message1();
	//private SendTcpServer send;

	public ServerThread(Socket s) { // serverThread�Ĺ�����
		this.clientRequest = s;
		//this.send=new SendTcpServer();
	}

	public void run() { // �̵߳�ִ�з���
		while (flag) {
			try {
				SocketAddress clientAddress = clientRequest
						.getRemoteSocketAddress();
				byte[] receiveBuf = new byte[BUFSIZE]; // Receive buffer
				InputStream in = clientRequest.getInputStream();
				OutputStream out = clientRequest.getOutputStream();
				while ((recvMsgSize = in.read(receiveBuf)) != -1) { // ֻҪ�ͻ����ڷ����ݾͻ᷵�ظ��ͻ�������

					/* @1:��ӡ�ӿͻ��˽��յ�֡���� */
//					System.out.println("---���յ���IP�Ͷ˿�" + clientAddress
//							+ "---���յ�������"
//							+ new String(receiveBuf, 0, recvMsgSize)
//							+ "---���յ������ݴ�С"
//							+ new String(receiveBuf, 0, recvMsgSize).length());
					//send.send("111", 2, "33333");
					
					//out.write("6666666666".getBytes());
					String str = new String(receiveBuf, 0, recvMsgSize);
					String str1 = str.substring(10, 13);
					String str2 = str.substring(13, 15);
					System.out.println("�¶�"+str1);
					System.out.println("ʪ��"+str2);                                                                                                                                                                                                                                                                                                          
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
