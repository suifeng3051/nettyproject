package heaven.bonree.server;

import heaven.bonree.protobuf.tasks.PBTaskRequest.PB_TaskRequest;
import heaven.bonree.service.TCPServerHandler;
import heaven.bonree.test.SocketClientDemo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-6-18
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: TCPServerDemo.java
 * @Package NettyDemo.bonree.server
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class TCPServerDemo {
	
	public static final String IP = "localhost";
	public static final int PORT = 8080;
	/**用于分配处理业务线程的线程组个数 */
	protected static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors()*2;	//默认
	/** 业务出现线程大小*/
	protected static final int BIZTHREADSIZE = 4;
	private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
	private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);
	protected static void run() throws Exception {
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup);
		b.channel(NioServerSocketChannel.class);
		b.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			public void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pipeline = ch.pipeline();				
				pipeline.addLast("frameDecoder", new FixedLengthFrameDecoder(SocketClientDemo.packageSize*10));
				//pipeline.addLast("frameEncoder",new LengthFieldPrepender(4));
				
				pipeline.addLast("probufDecoder", new ProtobufDecoder(PB_TaskRequest.getDefaultInstance()));
				pipeline.addLast(workerGroup,new TCPServerHandler());
				
				
			}
		});
		b.bind(IP, PORT).sync();
		System.out.println("TCP服务器已启动");
	}

	protected static void shutdown() {
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("开始启动http服务器...");
		TCPServerDemo.run();
//		TcpServer.shutdown();
	}
}

