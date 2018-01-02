package com.hhy.mydubbo.server;

import com.hhy.mydubbo.Code.Decode;
import com.hhy.mydubbo.Code.Encode;
import com.hhy.mydubbo.rpcserver.RpcServerHandler;
import com.hhy.mydubbo.service.HelloServiceImpl;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class RpcServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);

//    private String serviceAddress;
    private String url;
    public RpcServer(String url){
        this.url=url;
        handlerMap.put("com.hhy.mydubbo.service.HelloService", new HelloServiceImpl());
    }

//    private ServiceRegistry serviceRegistry;

    /**
     * 存放 服务名 与 服务对象 之间的映射关系
     */
    private Map<String, Object> handlerMap = new HashMap<>();

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
//            Thread.sleep(10000);
            // 创建并初始化 Netty 服务端 Bootstrap 对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel channel) throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast(new Decode()); // 解码 RPC 请求
                    pipeline.addLast(new Encode()); // 编码 RPC 响应
                    pipeline.addLast(new RpcServerHandler(handlerMap)); // 处理 RPC 请求
                }
            });
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            // 获取 RPC 服务器的 IP 地址与端口号
//            String[] addressArray = StringUtils.split(serviceAddress, ":");
//            String ip = addressArray[0];
//            int port = Integer.parseInt(addressArray[1]);
            String[] address=url.split(":");
            String host=address[0];
            int port=Integer.valueOf(address[1]);
            // 启动 RPC 服务器
            ChannelFuture future = bootstrap.bind(host, port).sync();
            // 注册 RPC 服务地址
            LOGGER.debug("server started on port {}", port);
            // 关闭 RPC 服务器
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
