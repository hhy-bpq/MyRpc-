package com.hhy.mydubbo.test;

import com.hhy.mydubbo.proxy.RpcProxy;
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
public class ClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientTest.class);
    public static void main(String[] args) throws InterruptedException {
//        for(int i=0;i<1000;i++){
//            MyThread myThread=new MyThread(i);
//            myThread.start();
//        }
        String url= "127.0.0.1:9020";
        RpcProxy rpcProxy =new RpcProxy(url);

        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        System.out.println("get result："+result);
        Person p=new Person();
        p.setName("Test");
        p.setAge(123);
        Person fa=new Person();
        fa.setName("father");
        fa.setAge(55);
        p.setFa(fa);
        List<String>list=new ArrayList<>();
        list.add("asdasd");
        list.add("a122");
        p.setList(list);
        Person p1=helloService.helloPerson(p);
        System.out.println(p1);
        long time = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            Person p2=helloService.helloPerson(p);
            System.out.println(p2);
            Thread.sleep(60*1000*5);
        }
        long t1=System.currentTimeMillis() - time;
        LOGGER.info("time: {}ms",t1);
    }
}
