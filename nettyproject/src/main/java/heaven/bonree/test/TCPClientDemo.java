package heaven.bonree.test;

import heaven.bonree.server.TCPServerDemo;
import heaven.bonree.service.TCPClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-6-18 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: TCPClientDemo.java
 * @Package NettyDemo.bonree.test Description: Version: 1.0
 ******************************************************************************/
public class TCPClientDemo {
	
	public static Bootstrap bootstrap = getBootstrap();

	/**
	 * 初始化Bootstrap
	 * 
	 * @return
	 */
	public static final Bootstrap getBootstrap() {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(group).channel(NioSocketChannel.class);
		b.handler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				ChannelPipeline pipeline = ch.pipeline();
				pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
				pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
				pipeline.addLast("handler", new TCPClientHandler());
			}
		});
		// b.option(ChannelOption.SO_KEEPALIVE, true);
		return b;
	}

	public static final Channel getChannel(String host, int port) {
		Channel channel = null;
		try {
			channel = bootstrap.connect(host, port).sync().channel();
		} catch (Exception e) {

			return null;
		}
		return channel;
	}

	public static void sendMsg(Channel channel, Object msg) throws Exception {
		if (channel != null) {
			channel.writeAndFlush(msg).sync();
		} else {

		}
	}

	public static void main(String[] args) throws Exception {
		try {
			long t0 = System.nanoTime();
			byte[] value = null;
			Channel channel = null;
			for (int i = 0; i < 10; i++) {
				channel = getChannel(TCPServerDemo.IP, TCPServerDemo.PORT);
				value = ("hello").getBytes();
				ByteBufAllocator alloc = channel.alloc();
				ByteBuf buf = alloc.buffer(value.length);
				buf.writeBytes(value);
				TCPClientDemo.sendMsg(channel, buf);
			}
			long t1 = System.nanoTime();
			System.out.println((t1 - t0) / 1000000.0);
			Thread.sleep(5000);
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
