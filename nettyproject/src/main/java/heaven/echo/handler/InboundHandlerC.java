package heaven.echo.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-6
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: InboundHandlerC.java
 * @Package NettyDemo.echo.handler
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class InboundHandlerC extends SimpleChannelInboundHandler<String>{

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, String arg1)
			throws Exception {
		System.out.println("InboundHandlerC received:"+arg1);
		
	}}

