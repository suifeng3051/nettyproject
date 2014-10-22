package heaven.echo.server;

import heaven.echo.handler.InboundHandlerA;
import heaven.echo.handler.InboundHandlerB;
import heaven.echo.handler.InboundHandlerC;
import heaven.echo.handler.OutboundHandlerA;
import heaven.echo.handler.OutboundHandlerB;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-6
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: TestPiplineServer.java
 * @Package NettyDemo.echo.server
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class TestPiplineServer {
private static final int port=8080;
	
	
	public void start() throws InterruptedException{
		ServerBootstrap b=new ServerBootstrap();//引导辅助程序
		EventLoopGroup group=new NioEventLoopGroup();//用来接收连接和处理连接
		try{
		b.group(group);
		b.channel(NioServerSocketChannel.class);//设置nio类型的channel
		b.localAddress(new InetSocketAddress(port));//设置监听端口
		b.childHandler(new ChannelInitializer<SocketChannel>() {//有连接到达时被调用，创建子channel

			protected void initChannel(SocketChannel ch) throws Exception {
				//在channel队列中添加一个自定义的handler
				ch.pipeline().addLast("inhandlerA",new InboundHandlerA());
				ch.pipeline().addLast("inhandlerB",new InboundHandlerB());
				ch.pipeline().addLast("inhandlerC",new InboundHandlerC());
				ch.pipeline().addLast("outhandlerA",new OutboundHandlerA());
				ch.pipeline().addLast("outhandlerB",new OutboundHandlerB());
			}
			
			
		});
		ChannelFuture f=b.bind().sync();//配置完成，开始绑定到server直到成功
		System.out.println(EchoServer.class.getName()+" started and listen on "+f.channel().localAddress());
		f.addListener(new ChannelFutureListener() {
			
			public void operationComplete(ChannelFuture future) throws Exception {
				if(future.isSuccess()){
					System.out.println("server bound");
				}else{
					System.out.println("server attemp failed");
					future.cause().printStackTrace();
				}
				
			}
		});
		
		
		f.channel().closeFuture().sync();//等待channel关闭
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) {
		try {
			new EchoServer().start();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

}

