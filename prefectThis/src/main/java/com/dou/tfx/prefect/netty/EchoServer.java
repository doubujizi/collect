//package com.dou.tfx.prefect.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
///**
// * @author tianfuxian
// * @Description:
// * @Date: 2021/2/9 5:18 下午
// */
//public final class EchoServer {
//    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
//
//    public static void main(String[] args) {
//        //创建EventLoopGroup accept线程组 NioEventLoop
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        //创建EventLoopGroup I/O线程组
//        EventLoopGroup workerGroup2 = new NioEventLoopGroup();
//
//        try {
//            //服务端启动引导工具类
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup, workerGroup2)
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 100)
//                    .handler(new LoggingHandler(LogLevel.DEBUG))
//                    .childHandler( (ChannelInitializer)(ch) -> {
//                        ChannelPipeline p = ch.pipeline();
//                        p.addLast(new );
//                    });
//            ChannelFuture f = b.bind(PORT).sync();
//            f.channel().closeFuture().sync();
//        } finally {
//
//        }
//    }
//}
