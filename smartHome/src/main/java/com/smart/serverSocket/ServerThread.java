package com.smart.serverSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerThread extends Thread {
	private Socket clientRequest; // �û����ӵ�ͨ���׽���
	private int recvMsgSize; // Size of received message
	private static final int BUFSIZE = 1024; // Size of receive buffer
	private boolean flag = true;

	public ServerThread(Socket s) { // serverThread�Ĺ�����
		this.clientRequest = s;
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
					System.out.println("---���յ���IP�Ͷ˿�" + clientAddress
							+ "---���յ�������"
							+ new String(receiveBuf, 0, recvMsgSize)
							+ "---���յ������ݴ�С"
							+ new String(receiveBuf, 0, recvMsgSize).length());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// end of run

	
}
