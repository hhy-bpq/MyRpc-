package com.hhy.mydubbo.rpcserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/19
 */

@Component
@Configuration
public class RpcConfig {

    @Value("${rpcServer.localAddress}")
    private  String url;
    @Value("${rpcServer.name}")
    private  String name;
    @Value("${rpcServer.registAddress}")
    private  String registAddress;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getRegistAddress() {
        return registAddress;
    }

}
