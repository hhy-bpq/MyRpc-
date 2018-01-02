package com.hhy.mydubbo.test;

import com.hhy.mydubbo.protobuf.client.ProtoRpcProxy2;
import com.hhy.mydubbo.protobuf.client.ProtoRpcProxy3;
import com.hhy.mydubbo.service.HelloService;
import com.hhy.mydubbo.service.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class ProtoClientTest3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoClientTest3.class);
    public static void main(String[] args) {
        String url="127.0.0.1:9020";
        ProtoRpcProxy3 rpcProxy =new ProtoRpcProxy3(url);

        Person p=new Person();
        p.setName("ads");
        p.setAge(1);
        HelloService helloService = rpcProxy.create(HelloService.class);
        String p2=helloService.hello("asdas");
        System.out.println(p2);
    }
}
