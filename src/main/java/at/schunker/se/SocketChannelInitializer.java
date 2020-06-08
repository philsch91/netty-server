package at.schunker.se;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class SocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    //initChannel() is called whenever a new incoming TCP connection is accepted by the TCP server.
    //A new ServerHandler (a ChannelHandler) is attached to each new SocketChannel.
    public void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("serverHandler", new ServerHandler());
    }
}
