package heaven.bonree.service;

import io.netty.buffer.ByteBuf;
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
 * @Title: TCPClientHandler.java
 * @Package NettyDemo.bonree.service Description: Version: 1.0
 ******************************************************************************/
public class TCPClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof ByteBuf) {
			ByteBuf buf = (ByteBuf) msg;
			byte[] dst = new byte[buf.capacity()];
			buf.readBytes(dst);
			System.out.println("client接收到服务器返回的消息:" + new String(dst));
			ReferenceCountUtil.release(msg);
		} else {

		}

	}

}
