package heaven.bonree.service;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-6-18 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: TCPServerHandler.java
 * @Package NettyDemo.bonree.service Description: Version: 1.0
 ******************************************************************************/
public class TCPServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof ByteBuf) {
			ByteBuf buf = (ByteBuf) msg;
			int capacity=buf.readableBytes();
			byte[] dst = new byte[capacity];
			buf.readBytes(dst);
			byte[] dest = (new String(dst) + ". yes, server is accepted you ,nice !").getBytes();
			ByteBuf destBuf = ctx.alloc().buffer(dest.length);
			destBuf.writeBytes(dest);
			System.out.println("SERVER接收到消息大小:"+dst.length/1024);
			ctx.channel().writeAndFlush(destBuf);
			ReferenceCountUtil.release(msg);
		} else {

		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		System.out.println("exception!");
		ctx.close();
	}
}
