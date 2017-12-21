package com.hhy.mydubbo.protobuf.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hhy.mydubbo.protobuf.bean.RpcRequestProto;
import com.hhy.mydubbo.protobuf.bean.RpcResponseProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class ProtoServerHandler extends SimpleChannelInboundHandler<RpcRequestProto.RpcRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoServerHandler.class);

    private final Map<String, Object> handlerMap;

    public ProtoServerHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void channelRead0(final ChannelHandlerContext ctx, RpcRequestProto.RpcRequest request) throws Exception {
        // 创建并初始化 RPC 响应对象
//        response.setRequestId(request.getRequestId());
//        try {
            Object value = handle(request);
//            System.out.println(value.getClass());
            RpcResponseProto.RpcResponse response = resp(request.getID(),JSONObject.toJSONString(value),value.getClass().getName());
//            response.setResult(JSONObject.toJSONString(value));
//        } catch (Exception e) {
//            LOGGER.error("handle result failure", e);
////            response.setException(e);
//        }
        // 写入 RPC 响应对象并自动关闭连接

        ctx.writeAndFlush(response);
    }

    private Object handle(RpcRequestProto.RpcRequest request) throws Exception {
        // 获取服务对象
        String serviceVersion = request.getVersion();
        String serviceName=request.getPath();
//        if (StringUtils.isNotEmpty(serviceVersion)) {
//            serviceName += "-" + serviceVersion;
//        }
        Object serviceBean = handlerMap.get(serviceName);
        if (serviceBean == null) {
            throw new RuntimeException(String.format("can not find service bean by key: %s", serviceName));
        }
        // 获取反射调用所需的参数
        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = JSONObject.parseObject(request.getParameterTypes(),Class[].class);
        String[] obj=request.getParams().split("###");
        Object[] parameters = new Object[obj.length];
        for(int i=0;i<obj.length;i++){
            parameters[i]=JSONObject.parseObject(obj[i],parameterTypes[i]);
        }
        // 执行反射调用
//        Method method = serviceClass.getMethod(methodName, parameterTypes);
//        method.setAccessible(true);
//        return method.invoke(serviceBean, parameters);
        // 使用 CGLib 执行反射调用
        FastClass serviceFastClass = FastClass.create(serviceClass);
        FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
        return serviceFastMethod.invoke(serviceBean, parameters);
    }
    private RpcResponseProto.RpcResponse resp(long id,String result,String resultType) {
        RpcResponseProto.RpcResponse.Builder builder = RpcResponseProto.RpcResponse.newBuilder();
        builder.setID(id);
        builder.setEvent(false);
        builder.setResult(result);
        builder.setResultType(resultType);
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("server caught exception", cause);
        ctx.close();
    }
}
