package com.hhy.mydubbo.client;

import com.hhy.mydubbo.Code.Decode;
import com.hhy.mydubbo.Code.Encode;
import com.hhy.mydubbo.bean.Request;
import com.hhy.mydubbo.bean.Response;
import com.hhy.mydubbo.rpcclient.Storage;
import com.hhy.mydubbo.server.HeartbeatHandlerInitializer;
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
 * 共享连接的客户端  解决线程池膨胀问题
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
@ChannelHandler.Sharable
public class LonConClient2 extends SimpleChannelInboundHandler<Response> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LonConClient2.class);

    private static final LonConClient2 INSTANCE=new LonConClient2();

    private Bootstrap bootstrap ;
    private Map<Long,Storage> resulMap=new ConcurrentHashMap<Long,Storage>();
    private Map<String,Channel> clientMap=new ConcurrentHashMap<String,Channel>();
    private Map<String,Object> lockMap=new ConcurrentHashMap<String,Object>();

    private LonConClient2() {
    }

    public static LonConClient2 getINSTANCE() {
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
        Storage storage=new Storage();
        resulMap.put(request.getId(),storage);
        Channel channel=getClient(url);
//        System.out.println("open:"+channel.isOpen());
//        System.out.println("active:"+channel.isActive());
        if(channel!=null){
            channel.write(request);
            channel.flush();
        }else{
            throw new Exception("没有channel");
        }
        return storage;
    }
    public boolean isActive(String url) throws InterruptedException {
        Channel channel=getClient(url);
        System.out.println(channel.isOpen());
        return channel.isActive();
    }
    private Channel getClient(String url) throws InterruptedException {
        Object obj=lockMap.get(url);
        if(obj==null){
            obj=new Object();
            lockMap.put(url,obj);
        }
        Channel channel=null;
        synchronized (obj){
            channel= clientMap.get(url);
            if(channel!=null&&!channel.isActive()){
                channel.close();
                clientMap.remove(url);
                channel=null;
            }
            if(channel==null){
                if(bootstrap==null){
                    System.out.println("新客户端");
                    EventLoopGroup group = new NioEventLoopGroup();
                    bootstrap = new Bootstrap();
                    bootstrap.group(group);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new Encode()); // 编码 RPC 请求
                            pipeline.addLast(new Decode()); // 解码 RPC 响应
                            pipeline.addLast(LonConClient2.this); // 处理 RPC 响应
                            pipeline.addLast(new HeartbeatHandlerInitializer());
                        }
                    });
                    bootstrap.option(ChannelOption.TCP_NODELAY, true);
                }
                String[] address=url.split(":");
                String host=address[0];
                int port=Integer.valueOf(address[1]);
                ChannelFuture channelFuture=bootstrap.connect(host, port).sync();
                channel=channelFuture.channel();
                clientMap.put(url,channel);
                System.out.println(clientMap.size());
            }
        }

        return channel;
    }
}
