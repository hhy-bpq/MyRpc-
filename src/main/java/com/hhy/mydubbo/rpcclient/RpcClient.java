package com.hhy.mydubbo.rpcclient;

import com.hhy.mydubbo.Code.Decode;
import com.hhy.mydubbo.Code.Encode;
import com.hhy.mydubbo.bean.Request;
import com.hhy.mydubbo.bean.Response;
import com.hhy.mydubbo.product.Storage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 共享连接的客户端（需要加上心跳来保持长连接）
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class RpcClient extends SimpleChannelInboundHandler<Response> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);

    private static final RpcClient INSTANCE=new RpcClient();

//    private String url;
    private Map<Long,Storage> resulMap=new ConcurrentHashMap<Long,Storage>();
    private Map<String,Channel> clientMap=new ConcurrentHashMap<String,Channel>();

    private RpcClient() {
    }

    public static RpcClient getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Response response) throws Exception {
        Storage storage=resulMap.get(response.getId());
        if(storage!=null){
            storage.set(response);
            resulMap.remove(response.getId());
        }else{
            System.out.println("stroage 为空");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("api caught exception", cause);
        ctx.close();
    }

    public  Storage send(String url,Request request) throws Exception {
        Channel channel=getClient(url);
        Storage storage=new Storage();
        resulMap.put(request.getId(),storage);
        System.out.println("open:"+channel.isOpen());
        if(channel!=null){
            channel.write(request);
            channel.flush();
        }else{
            throw new Exception("没有channel");
        }
        return storage;
    }
    private Channel getClient(String url) throws InterruptedException {
        Channel channel= clientMap.get(url);
        if(channel==null){
            EventLoopGroup group = new NioEventLoopGroup();
//            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new Encode()); // 编码 RPC 请求
                        pipeline.addLast(new Decode()); // 解码 RPC 响应
                        pipeline.addLast(RpcClient.this); // 处理 RPC 响应
                    }
                });
                bootstrap.option(ChannelOption.TCP_NODELAY, true);
                String[] address=url.split(":");
                String host=address[0];
                int port=Integer.valueOf(address[1]);
                ChannelFuture channelFuture=bootstrap.connect(host, port).sync();
                channel=channelFuture.channel();
                clientMap.put(url,channel);
//            } finally {
////                group.shutdownGracefully();
//            }
        }
        return channel;
    }
    class HeartThread extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
