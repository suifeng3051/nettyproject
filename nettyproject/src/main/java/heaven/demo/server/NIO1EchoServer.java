package heaven.demo.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIO1EchoServer {
	public void serve(int port) throws IOException {
		System.out.println("Listening for connections on port " + port);
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		//绑定server到端口 
		InetSocketAddress address = new InetSocketAddress(port);
		ss.bind(address);
		serverChannel.configureBlocking(false);
		Selector selector = Selector.open();
		//注册Channel给Selector
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			try {
				//阻塞
				selector.select();
			} catch (IOException ex) {
				ex.printStackTrace();
				// handle in a proper way
				break;
			}
			//获取所有selectedKey实例
			Set readyKeys = selector.selectedKeys();
			Iterator iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				//removeSelectionKey
				SelectionKey key = (SelectionKey) iterator.next();
				iterator.remove();
				try {
					if (key.isAcceptable()) {
						//接收客户端连接
						ServerSocketChannel server = (ServerSocketChannel) key
								.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from " + client);
						//注册连接到channel，设置ByteBuffer
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_WRITE,ByteBuffer.allocate(100));
					}
					if (key.isReadable()) {//监听读事件
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						client.read(output);
					}
					if (key.isWritable()) {//监听写事件
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						output.flip();
						client.write(output);
						output.compact();
					}
				} catch (IOException ex) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException cex) {
					}
				}
			}
		}
	}
}
