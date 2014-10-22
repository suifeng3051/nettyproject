package heaven.file.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2014 博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved. BidPlanStructForm.java Created on 2014-8-19 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: HttpFileServer.java
 * @Package NettyDemo.file.server Description: Version: 1.0
 ******************************************************************************/
public class HttpFileServer {
	static final int PORT = 8080;
	public static void main(String[] args) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() {// 有连接到达时会创建一个channel
								@Override
								protected void initChannel(SocketChannel ch) throws Exception {
									ChannelPipeline pipeline = ch.pipeline();
									pipeline.addLast(new HttpServerCodec());
									pipeline.addLast(new HttpObjectAggregator(Integer.MAX_VALUE));
									pipeline.addLast(new ChunkedWriteHandler());
									pipeline.addLast(new FileServerHandler());
								}
							});

			Channel ch = b.bind(PORT).sync().channel();
			System.err.println("打开浏览器，输入： " + ("http") + "://127.0.0.1:" + PORT + '/');
			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
