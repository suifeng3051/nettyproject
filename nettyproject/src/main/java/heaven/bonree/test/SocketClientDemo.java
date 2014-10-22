package heaven.bonree.test;

import heaven.bonree.protobuf.tasks.PBTaskRequest.PB_TaskRequest;
import heaven.bonree.server.TCPServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-6-18 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: SocketClientDemo.java
 * @Package NettyDemo.bonree.test Description: Version: 1.0
 ******************************************************************************/
public class SocketClientDemo {
	public static final int packageSize=1024*1024*10;

	
	public static void main(String args[]) throws IOException {
		System.out.println(Integer.MAX_VALUE);
		Socket socket = new Socket(TCPServerDemo.IP, TCPServerDemo.PORT);
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String readline;
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<packageSize;i++){
			
				sb.append("aaaaaaaaa").append("\r\n");
			
		}
		PB_TaskRequest.Builder request = PB_TaskRequest.newBuilder();
		request.setPwd("asdf");
		request.addTaskId("asdf");
		request.setUsername("asdf");
		request.addTaskType("sdf");
		//os.println(request.build().toByteArray());
		os.println(sb);
		os.flush();
		System.out.println("Client:" + "wang");
		while((readline=is.readLine())!=null){
			System.out.println("Server:" + readline);
		}
		
		readline = sin.readLine(); // 从系统标准输入读入一字符串

		os.close();
		is.close();
		socket.close();
	}
}
