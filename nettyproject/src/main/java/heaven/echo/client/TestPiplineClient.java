package heaven.echo.client;

import heaven.echo.handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-6
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: TestPiplineClient.java
 * @Package NettyDemo.echo.client
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class TestPiplineClient {
	private final String host;
	private final int port;

	public TestPiplineClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group);
			b.channel(NioSocketChannel.class);
			b.remoteAddress(new InetSocketAddress(host, port));
			b.handler(new ChannelInitializer<SocketChannel>() {

				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new EchoClientHandler());
				}
			});
			ChannelFuture f = b.connect().sync();
			f.addListener(new ChannelFutureListener() {
				
				public void operationComplete(ChannelFuture future) throws Exception {
					if(future.isSuccess()){
						System.out.println("client connected");
					}else{
						System.out.println("server attemp failed");
						future.cause().printStackTrace();
					}
					
				}
			});
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {
	
		new EchoClient("127.0.0.1", 3331).start();
	}
}

