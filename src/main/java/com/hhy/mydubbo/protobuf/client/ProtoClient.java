package com.hhy.mydubbo.protobuf.client;

import com.hhy.mydubbo.protobuf.bean.RpcRequestProto;
import com.hhy.mydubbo.protobuf.bean.RpcResponseProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class ProtoClient extends SimpleChannelInboundHandler<RpcResponseProto.RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoClient.class);

    private String url;

    private RpcResponseProto.RpcResponse response;
    private RpcRequestProto.RpcRequest request;
    private int count=0;
    private long times=1000000;
//    private long times=1000000;

    public ProtoClient(String url, RpcRequestProto.RpcRequest request) {
        this.url = url;
        this.request=request;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for(long i=0;i<times;i++){
            ctx.writeAndFlush(request);
        }
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx, RpcResponseProto.RpcResponse response) throws Exception {
//        System.out.println(count);
        if(++count>=times){
            this.response = response;
            ctx.close();

        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("api caught exception", cause);
        ctx.close();
    }

    public RpcResponseProto.RpcResponse send() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建并初始化 Netty 客户端 Bootstrap 对象
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel channel) throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast(new ChannelHandler[]{new ProtobufVarint32FrameDecoder()});
                    pipeline.addLast(new ChannelHandler[]{new ProtobufDecoder(RpcResponseProto.RpcResponse.getDefaultInstance())});
                    pipeline.addLast(new ChannelHandler[]{new ProtobufVarint32LengthFieldPrepender()});
                    pipeline.addLast(new ChannelHandler[]{new ProtobufEncoder()});
                    pipeline.addLast(ProtoClient.this); // 处理 RPC 响应
                }
            });
            bootstrap.option(ChannelOption.TCP_NODELAY, true);
            String[] address=url.split(":");
            String host=address[0];
            int port=Integer.valueOf(address[1]);
            // 连接 RPC 服务器
            ChannelFuture future = bootstrap.connect(host, port).sync();
            // 写入 RPC 请求数据并关闭连接
            Channel channel = future.channel();
//            channel.writeAndFlush(request).sync();
            channel.closeFuture().sync();
            // 返回 RPC 响应对象
            return response;
        } finally {
            group.shutdownGracefully();
        }
    }
}
