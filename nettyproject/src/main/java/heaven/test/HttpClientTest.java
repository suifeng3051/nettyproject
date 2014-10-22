package heaven.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2014 博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * BidPlanStructForm.java Created on 2014-8-19
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: HttpClientTest.java
 * @Package NettyDemo.test
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class HttpClientTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpHost proxy = new HttpHost("localhost", 8080);
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		HttpPost httppost = new HttpPost("http://www.java2000.net/login.jsp");
		HttpResponse response = httpclient.execute(httppost);
		byte[] array = EntityUtils.toByteArray(response.getEntity());
		System.out.println(array.length);
		File downloadFile = new File("d:/getfile.xls");  
		FileOutputStream fOutputStream =new FileOutputStream(downloadFile);
        fOutputStream.write(array);  
          
		
	}
}
