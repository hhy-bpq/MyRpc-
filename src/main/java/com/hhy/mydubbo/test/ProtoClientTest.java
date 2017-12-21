package com.hhy.mydubbo.test;

import com.hhy.mydubbo.protobuf.client.ProtoRpcProxy;
import com.hhy.mydubbo.proxy.PerforRpcProxy;
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
public class ProtoClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoClientTest.class);
    public static void main(String[] args) {
        String url="127.0.0.1:9030";
        ProtoRpcProxy rpcProxy =new ProtoRpcProxy(url);

        HelloService helloService = rpcProxy.create(HelloService.class);

        Person p=new Person();
        p.setName("Test\\n\\m\\\\r/r{[]:''@3124!@#$%^&&*}<>?\\///\\as sa");
        p.setAge(123);
        Person fa=new Person();
        fa.setName("father");
        fa.setAge(55);
        p.setFa(fa);
        List<String> list=new ArrayList<>();
        list.add("asdasd");
        list.add("a122");
        p.setList(list);
        System.out.println(p.getName().equals("Test\\n\\m\\\\r/r{[]:''@3124!@#$%^&&*}<>?\\///\\as sa"));
        long time = System.currentTimeMillis();
        helloService.helloPerson(p);
        long t1=System.currentTimeMillis() - time;
        LOGGER.info("time: {}ms",t1);
//        System.out.println(qwe.getName());
//        System.out.println(qwe.getName().equals(p.getName()));
    }
}
