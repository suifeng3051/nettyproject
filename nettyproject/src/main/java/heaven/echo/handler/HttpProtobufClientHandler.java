package heaven.echo.handler;

import heaven.echo.protocal.AddressBookProtos;
import heaven.echo.protocal.AddressBookProtos.AddressBook;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpResponse;

public class HttpProtobufClientHandler extends SimpleChannelInboundHandler<HttpResponse>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpResponse msg)
			throws Exception {
		System.out.println("client recieved msg:"+msg);
		//AddressBook.parseFrom();
	}

}
