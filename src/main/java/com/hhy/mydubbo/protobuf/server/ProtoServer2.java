package com.hhy.mydubbo.protobuf.server;

import com.hhy.mydubbo.protobuf.bean.RpcProto;
import com.hhy.mydubbo.protobuf.bean.RpcRequestProto;
import com.hhy.mydubbo.service.HelloServiceImpl;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/20
 */
public class ProtoServer2 {
    private String url;
    private Map<String, Object> handlerMap = new HashMap<>(); // 存放接口名与服务对象之间的映射关系
    public ProtoServer2(String url){
        this.url=url;
        handlerMap.put("com.hhy.mydubbo.service.HelloService",new HelloServiceImpl());
    }
    public void start() throws Exception {
        // 配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                             ch.pipeline().addLast(
                             new ProtobufVarint32FrameDecoder());
                            ch.pipeline().addLast(
                                    new ProtobufDecoder(
                                            RpcProto.ProtoData
                                                    .getDefaultInstance()));
                            ch.pipeline().addLast(
                                    new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            ch.pipeline().addLast(new ProtoServerHandler2(handlerMap));
                        }
                    });

            // 绑定端口，同步等待成功
            String[] add=url.split(":");
            String host=add[0];
            int port=Integer.valueOf(add[1]);
            ChannelFuture f = b.bind(host,port).sync();

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
