package com.hhy.mydubbo.protobuf.client;

import com.alibaba.fastjson.JSONObject;
import com.hhy.mydubbo.protobuf.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class ProtoRpcProxy2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoRpcProxy2.class);

    //java 提供的自增长计数器
    private static final AtomicLong INVOKE_ID = new AtomicLong(0);
    private String  url;

//    private ServiceDiscovery serviceDiscovery;

    private static long newId() {
        // getAndIncrement()增长到MAX_VALUE时，再增长会变为MIN_VALUE，负数也可以做为ID
        return INVOKE_ID.getAndIncrement();
    }
    public ProtoRpcProxy2(String url) {
        this.url = url;
    }

//    public RpcProxy(ServiceDiscovery serviceDiscovery) {
//        this.serviceDiscovery = serviceDiscovery;
//    }

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<?> interfaceClass) {
        return create(interfaceClass, "");
    }

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<?> interfaceClass, final String serviceVersion) {
        // 创建动态代理对象
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 创建 RPC 请求对象并设置请求属性
                        Request request=new Request();
                        request.setPath(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParams(args);
                        request.setVersion(serviceVersion);
                        RpcProto.ProtoData.Builder builder=req();
                        builder.setData(JSONObject.toJSONString(request));
//                        // 创建 RPC 客户端对象并发送 RPC 请求
                        ProtoClient2 client = new ProtoClient2(url,builder.build());
//                        long time = System.currentTimeMillis();
                        Response response = client.send();
//                        LOGGER.info("time: {}ms", System.currentTimeMillis() - time);
                        if (response == null) {
                            throw new RuntimeException("response is null");
                        }
                        // 返回 RPC 响应结果
//                        if (!StringUtils.isBlank(response.getErrorMsg())) {
//                            throw new Exception(response.getErrorMsg());
//                        } else {

                        return JSONObject.parseObject(response.getResult().toString(),Class.forName(response.getResultType()));
//                        }
                    }
                }
        );
    }
    private RpcProto.ProtoData.Builder req() {
        RpcProto.ProtoData.Builder builder = RpcProto.ProtoData.newBuilder();
        builder.setID(newId());
        builder.setEvent(false);
        builder.setTwoWay(true);
        builder.setIsRequest(true);
        return builder;
    }
}
