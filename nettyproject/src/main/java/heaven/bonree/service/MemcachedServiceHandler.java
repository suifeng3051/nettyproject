package heaven.bonree.service;

import heaven.bonree.protobuf.tasks.PBMBTaskResult.PB_MBTaskResult;
import heaven.bonree.protobuf.tasks.PBTaskRequest.PB_TaskRequest;
import heaven.bonree.service.MemcachedService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.util.ArrayList;
import java.util.List;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-28
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MemcachedServiceHandler.java
 * @Package NettyDemo.bonree.service
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class MemcachedServiceHandler extends SimpleChannelInboundHandler<Object>{
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,	Object msg) throws Exception {
		DefaultFullHttpRequest request=(DefaultFullHttpRequest)msg;
		//PB_TaskRequest task=PB_TaskRequest.parseFrom(request.content().array());
		//List<String> taskList = new ArrayList<String>();
		//taskList.addAll(task.getTaskIdList());
		//PB_MBTaskResult.Builder mbTaskbuilder = PB_MBTaskResult.newBuilder();
		//mbTaskbuilder.addAllNetenvResult(service.getNetData(taskList));
		//mbTaskbuilder.addAllNavigateResult(service.getNavData(taskList));
		//ByteBuf content=Unpooled.wrappedBuffer(mbTaskbuilder.build().toByteArray());
		//DefaultFullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.ACCEPTED, content);
		//ctx.writeAndFlush(response);
		MemcachedService service = new MemcachedService();
		service.queryBusinessData("t_mcc_stat_navigate", "229882", "2012-12-31 0~2012-12-31 4");
	}
}

