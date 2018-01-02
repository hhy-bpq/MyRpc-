package com.hhy.mydubbo.protobuf.server;

import com.alibaba.fastjson.JSONObject;
import com.cyp.chx.rcenter.protobuff.bean.ProtoRequest;
import com.cyp.chx.rcenter.protobuff.bean.ProtoResponse;
import com.cyp.chx.rcenter.protobuff.bean.RpcProto;
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
public class ProtoServerHandler3 extends SimpleChannelInboundHandler<RpcProto.ProtoData> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoServerHandler3.class);

    private final Map<String, Object> handlerMap;

    public ProtoServerHandler3(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void channelRead0(final ChannelHandlerContext ctx, RpcProto.ProtoData request) throws Exception {
        // 创建并初始化 RPC 响应对象
//        response.setRequestId(request.getRequestId());
        try {
            Object value = handle(request);
//            System.out.println(value.getClass());
            ProtoResponse response=new ProtoResponse(request.getID());
            response.setResult(value);
            response.setResultType(value.getClass().getName());
            RpcProto.ProtoData data = resp(request.getID(),JSONObject.toJSONString(response));
//            response.setResult(JSONObject.toJSONString(value));
            ctx.writeAndFlush(data);
        } catch (Exception e) {
            LOGGER.error("handle result failure", e);
//            response.setException(e);
        }
    }

    private Object handle(RpcProto.ProtoData data) throws Exception {
        // 获取服务对象
        ProtoRequest request=JSONObject.parseObject(data.getData(),ProtoRequest.class);
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
        Class<?>[] parameterTypes =request.getParameterTypes();
        Object[] parameters =new Object[parameterTypes.length];
        for(int i=0;i<parameterTypes.length;i++){
            Object ob=request.getParams()[i];
            JSONObject jsonObjects1=null;
            System.out.println(ob.getClass().getName());
            if( ob instanceof  JSONObject){
                jsonObjects1= (JSONObject) request.getParams()[i];
                parameters[i]=jsonObjects1.toJavaObject(parameterTypes[i]);
            }else{
                parameters[i]=ob;
            }
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

    private RpcProto.ProtoData resp(long id,String result) {
        RpcProto.ProtoData.Builder builder = RpcProto.ProtoData.newBuilder();
        builder.setID(id);
        builder.setEvent(false);
        builder.setData(result);
        return builder.build();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("server caught exception", cause);
        ctx.close();
    }
}
