package com.hhy.mydubbo.rpcserver;

import com.hhy.mydubbo.Code.Decode;
import com.hhy.mydubbo.Code.Encode;
import com.hhy.mydubbo.rpcclient.RpcServiceFactory;
import com.hhy.mydubbo.rpcregist.RegistService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/18
 */
@Service
public class RpcServer implements ApplicationContextAware, InitializingBean {

    private Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);

    @Autowired
    private RpcConfig rpcConfig;
    @Autowired
    private RpcServiceFactory rpcServiceFactory;

    private Map<String, Object> handlerMap = new HashMap<>(); // 存放接口名与服务对象之间的映射关系

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 扫描带有 RpcService 注解的类并初始化 handlerMap 对象
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (MapUtils.isNotEmpty(serviceBeanMap)) {
            for (Object serviceBean : serviceBeanMap.values()) {
                RpcService rpcService = serviceBean.getClass().getAnnotation(RpcService.class);
                String serviceName = rpcService.value().getName();
                String serviceVersion = rpcService.version();
                if (StringUtils.isNotEmpty(serviceVersion)) {
                    serviceName += "-" + serviceVersion;
                }
                handlerMap.put(serviceName, serviceBean);
            }
        }
    }

    private void start() {
        Thread serverThread=new Thread(new Runnable() {
            @Override
            public void run() {
                EventLoopGroup bossGroup = new NioEventLoopGroup();
                EventLoopGroup workerGroup = new NioEventLoopGroup();
                try {
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
                    bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
                    // 获取 RPC 服务器的 IP 地址与端口号
                    String[] address=rpcConfig.getUrl().split(":");
                    String host=address[0];
                    int port=Integer.valueOf(address[1]);
                    // 启动 RPC 服务器
                    ChannelFuture future = bootstrap.bind(host, port).sync();

                    LOGGER.debug("server started on port {}", port);
                    // 注册 RPC 服务地址
                    RegistService service= rpcServiceFactory.createByUrl(RegistService.class,rpcConfig.getRegistAddress());
                    service.regist(rpcConfig.getUrl(),rpcConfig.getName());
                    // 关闭 RPC 服务器
                    future.channel().closeFuture().sync();
                } catch (Exception e){
                    LOGGER.error("rpc 对外提供服务前程启动失败",e);
                }finally {
                    workerGroup.shutdownGracefully();
                    bossGroup.shutdownGracefully();
                }

            }
        });
        serverThread.start();
    }
}
