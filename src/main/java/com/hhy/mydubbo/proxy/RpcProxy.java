package com.hhy.mydubbo.proxy;

import com.hhy.mydubbo.bean.Request;
import com.hhy.mydubbo.bean.Response;
import com.hhy.mydubbo.client.RpcClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class RpcProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcProxy.class);

    private String  url;
    public RpcProxy(String url) {
        this.url = url;
    }

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
                        request.setParams(args);
                        request.setMethodName(method.getName());
                        request.setPath(method.getDeclaringClass().getName());
                        request.setParameterTypes(method.getParameterTypes());
                        String s=method.getDeclaringClass().getName();
                        request.setVersion(serviceVersion);
//                        // 创建 RPC 客户端对象并发送 RPC 请求
                        RpcClient client = new RpcClient(url);
//                        long time = System.currentTimeMillis();
                        Response response = client.send(request);
//                        LOGGER.info("time: {}ms", System.currentTimeMillis() - time);
                        if (response == null) {
                            throw new RuntimeException("response is null");
                        }
                        // 返回 RPC 响应结果
                        if (!StringUtils.isBlank(response.getErrorMsg())) {
                            throw new Exception(response.getErrorMsg());
                        } else {
                            return response.getResult();
                        }
                    }
                }
        );
    }
}
