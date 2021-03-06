package heaven.bonree.test;

import heaven.bonree.protobuf.tasks.PBMBTaskResult.PB_MBTaskResult;
import heaven.bonree.protobuf.tasks.PBTaskRequest.PB_TaskRequest;
import heaven.bonree.service.MbResultService;
import heaven.echo.server.HttpProtobufServer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2013-9-22 Author: <a
 * href=mailto:luojun@bonree.com>罗俊</a>
 * 
 * @Title: DataServlet.java
 * @Package com.bonree.servlet Description: Version: 1.0
 ******************************************************************************/
public class SendQueryTaskToNetty extends HttpServlet {
	private static final Logger log = Logger.getLogger(Logger.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PB_TaskResultRequest resultRequest =
		// PB_TaskResultRequest.parseFrom(new
		// BufferedInputStream(request.getInputStream()));
		MbResultService servcie = new MbResultService();
		String received=request.getInputStream().toString();
		List<String> taskList = new ArrayList<String>();
		taskList.add(received);
		PB_MBTaskResult.Builder mbTaskbuilder = PB_MBTaskResult.newBuilder();

		mbTaskbuilder.addAllNetenvResult(servcie.getNetData(taskList));
		mbTaskbuilder.addAllNavigateResult(servcie.getNavData(taskList));

		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(response.getOutputStream());
			out.write(mbTaskbuilder.build().toByteArray());
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {

		
		PB_TaskRequest.Builder taskRequest=PB_TaskRequest.newBuilder();
		taskRequest.setPwd("1234");
		taskRequest.setUsername("wanghouda");
		taskRequest.addTaskId("1356970444811");
		taskRequest.addTaskType("1");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpHost proxy = new HttpHost(HttpProtobufServer.IP,
				HttpProtobufServer.PORT);
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
				proxy);
		HttpPost httppost = new HttpPost("http://www.java2000.net/login.jsp");
		
		ByteArrayEntity entity = new ByteArrayEntity(taskRequest.build().toByteArray());
		httppost.setEntity(entity);
		HttpResponse response = httpclient.execute(httppost);
		System.out.println("----------------------------------------");
		System.out.println(response.getStatusLine());
		System.out.println("Response content length"+response.getEntity().getContentLength());
		System.out.println("Response content length: " + PB_MBTaskResult.parseFrom(response.getEntity().getContent()).toString());	
		System.out.println("success");
	}
	

}
