package com.hhy.mydubbo.rpcclient;

import com.hhy.mydubbo.rpcregist.RegistService;
import com.hhy.mydubbo.rpcserver.RpcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/19
 */
@Service
public class RpcServiceFactory {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RpcConfig rpcConfig;

    /**
     * 根据请求的服务名创建 service
     * @param interfaceClass
     * @param serverName
     * @param <T>
     * @return
     */
    public <T> T createByName(final Class<?> interfaceClass,String serverName){
        String url=getRpcUrl(serverName);
        if(url==null){

        }
        RpcProxy rpcProxy=new RpcProxy(url);
        return rpcProxy.create(interfaceClass);
    }
    /**
     * 根据rpc url 创建 service
     * @param interfaceClass
     * @param url
     * @param <T>
     * @return
     */
    public <T> T createByUrl(final Class<?> interfaceClass,String url){
        RpcProxy rpcProxy=new RpcProxy(url);
        return rpcProxy.create(interfaceClass);
    }

    /**
     * 根据服务名获取rpc url
     * @param name
     * @return
     */
    public String getRpcUrl(String name){
        // 注册 RPC 服务地址
        RpcProxy rpcProxy =new RpcProxy(rpcConfig.getRegistAddress());
        RegistService service= rpcProxy.create(RegistService.class);
        return service.getUrl(name);
    }
}
