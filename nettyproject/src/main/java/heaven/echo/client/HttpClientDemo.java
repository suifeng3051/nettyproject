package heaven.echo.client;

import heaven.echo.protocal.AddressBookProtos;
import heaven.echo.server.HttpProtobufServer;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponse;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class HttpClientDemo {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpHost proxy = new HttpHost(HttpProtobufServer.IP,
				HttpProtobufServer.PORT);
		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
				proxy);
		HttpPost httppost = new HttpPost("http://www.java2000.net/login.jsp");
		AddressBookProtos.AddressBook.Builder address = AddressBookProtos.AddressBook
				.newBuilder();
		for (int i = 0; i < 10; i++) {
			AddressBookProtos.Person.Builder person = AddressBookProtos.Person
					.newBuilder();
			person.setName("HeavenWang");
			person.setId(i);
			person.setEmail("wanghouda@126.com");
			address.addPerson(person);
		}
		ByteArrayEntity entity = new ByteArrayEntity(address.build().toByteArray());
		httppost.setEntity(entity);
		HttpResponse response = (HttpResponse)httpclient.execute(httppost);
		System.out.println(response.toString());
		System.out.println("success");
		
		
		
	}
}
