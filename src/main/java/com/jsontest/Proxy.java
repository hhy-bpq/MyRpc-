package com.jsontest;

import com.hhy.mydubbo.bean.Request;
import com.hhy.mydubbo.bean.Response;
import com.hhy.mydubbo.rpcclient.RpcClient;
import com.hhy.mydubbo.service.HelloServiceImpl;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proxy.class);

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<?> interfaceClass) {
        return create(interfaceClass, "");
    }

    @SuppressWarnings("unchecked")
    public <T> T create(final Class<?> interfaceClass, final String serviceVersion) {
        // 创建动态代理对象
        return (T) java.lang.reflect.Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 创建 RPC 请求对象并设置请求属性
//                        Request request=new Request();
//                        request.setParams(args);
//                        request.setMethodName(method.getName());
//                        request.setPath(method.getDeclaringClass().getName());
//                        request.setParameterTypes(method.getParameterTypes());
//                        String s=method.getDeclaringClass().getName();
//                        request.setVersion(serviceVersion);

                        FastClass serviceFastClass = FastClass.create(interfaceClass);
                        FastMethod serviceFastMethod = serviceFastClass.getMethod(method.getName(), method.getParameterTypes());
                        return serviceFastMethod.invoke(new HelloServiceImpl(), args);
                    }
                }
        );
    }
}
