package com.hhy.mydubbo.protobuf.client;

import com.alibaba.fastjson.JSONObject;
import com.hhy.mydubbo.protobuf.bean.Response;
import com.hhy.mydubbo.protobuf.bean.RpcProto;
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
public class ProtoClient2 extends SimpleChannelInboundHandler<RpcProto.ProtoData> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoClient2.class);

    private String url;

    private RpcProto.ProtoData data;
    private Response response;
    private int count=0;
    private long times=5000000;
//    private long times=1;

    public ProtoClient2(String url,RpcProto.ProtoData data) {
        this.url = url;
        this.data=data;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for(long i=0;i<times;i++){
            ctx.writeAndFlush(data);
        }
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,RpcProto.ProtoData data) throws Exception {
        System.out.println(count);
        Response response= JSONObject.parseObject(data.getData(),Response.class);
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

    public Response send() throws Exception {
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
                    pipeline.addLast(new ChannelHandler[]{new ProtobufDecoder(RpcProto.ProtoData.getDefaultInstance())});
                    pipeline.addLast(new ChannelHandler[]{new ProtobufVarint32LengthFieldPrepender()});
                    pipeline.addLast(new ChannelHandler[]{new ProtobufEncoder()});
                    pipeline.addLast(ProtoClient2.this); // 处理 RPC 响应
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
