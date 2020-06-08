package at.schunker.se;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class NettyServer {

    public static void main( String[] args ) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.bootstrap();
        System.out.println( "Netty Server started" );
    }

    public NettyServer(){
    }

    public void bootstrap(){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress("localhost", 9999));
            serverBootstrap.childHandler(new SocketChannelInitializer());

            //By calling sync() on the returned ChannelFuture
            //the main thread that creates the server waits until the server has started, before continuing.
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
