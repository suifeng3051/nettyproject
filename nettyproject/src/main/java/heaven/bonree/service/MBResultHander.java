package heaven.bonree.service;

import heaven.bonree.protobuf.tasks.PBMBTaskResult.PB_MBTaskResult;
import heaven.bonree.protobuf.tasks.PBTaskRequest.PB_TaskRequest;
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


public class MBResultHander extends SimpleChannelInboundHandler<Object>{
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,	Object msg) throws Exception {
		DefaultFullHttpRequest request=(DefaultFullHttpRequest)msg;
		PB_TaskRequest task=PB_TaskRequest.parseFrom(request.content().array());
		MbResultService service = new MbResultService();
		List<String> taskList = new ArrayList<String>();
		taskList.addAll(task.getTaskIdList());
		PB_MBTaskResult.Builder mbTaskbuilder = PB_MBTaskResult.newBuilder();
		mbTaskbuilder.addAllNetenvResult(service.getNetData(taskList));
		mbTaskbuilder.addAllNavigateResult(service.getNavData(taskList));
		ByteBuf content=Unpooled.wrappedBuffer(mbTaskbuilder.build().toByteArray());
		//System.out.println("server sent content "+content.toString());
		//System.out.println(PB_MBTaskResult.parseFrom(content.array()));
		DefaultFullHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.ACCEPTED, content);
	
		ctx.writeAndFlush(response);
	}
}
                                                      