package heaven.echo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-6 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: OutboundHandlerA.java
 * @Package NettyDemo.echo.handler Description: Version: 1.0
 ******************************************************************************/
public class OutboundHandlerA extends ChannelOutboundHandlerAdapter {

	@Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		System.out.println("OutboundHandlerA received:"+msg);
		ctx.write(msg, promise);
    }

}
