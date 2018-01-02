package com.hhy.mydubbo.protobuf.client;

import com.alibaba.fastjson.JSONObject;
import com.cyp.chx.rcenter.protobuff.bean.ProtoRequest;
import com.cyp.chx.rcenter.protobuff.bean.ProtoResponse;
import com.cyp.chx.rcenter.protobuff.bean.RpcProto;
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
public class ProtoRpcProxy3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoRpcProxy3.class);

    //java 提供的自增长计数器
    private static final AtomicLong INVOKE_ID = new AtomicLong(0);
    private String  url;

//    private ServiceDiscovery serviceDiscovery;

    private static long newId() {
        // getAndIncrement()增长到MAX_VALUE时，再增长会变为MIN_VALUE，负数也可以做为ID
        return INVOKE_ID.getAndIncrement();
    }
    public ProtoRpcProxy3(String url) {
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
                        ProtoRequest request=new ProtoRequest();
                        request.setPath(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParams(args);
                        request.setVersion(serviceVersion);
                        RpcProto.ProtoData.Builder builder=req();
                        builder.setData(JSONObject.toJSONString(request));
//                        // 创建 RPC 客户端对象并发送 RPC 请求
                        ProtoClient3 client = new ProtoClient3(url,builder.build());
//                        long time = System.currentTimeMillis();
                        RpcProto.ProtoData  data = client.send();
                        System.out.println(data);
                        ProtoResponse response= JSONObject.parseObject(data.getData(),ProtoResponse.class);
//                        LOGGER.info("time: {}ms", System.currentTimeMillis() - time);
                        if (response == null) {
                            throw new RuntimeException("response is null");
                        }
                        Object ob=response.getResult();
                        System.out.println(response.getResultType());
                        JSONObject jsonObjects1=null;
                        if( ob instanceof  JSONObject){
                            jsonObjects1= (JSONObject)ob;

                            return jsonObjects1.toJavaObject(Class.forName(response.getResultType()));
                        }else{
                            return ob;
                        }
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
