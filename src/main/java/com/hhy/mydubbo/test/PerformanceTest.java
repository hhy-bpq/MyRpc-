package com.hhy.mydubbo.test;

import com.hhy.mydubbo.proxy.PerforRpcProxy;
import com.hhy.mydubbo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class PerformanceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceTest.class);
    public static void main(String[] args) {
        String url="127.0.0.1:9020";
        PerforRpcProxy rpcProxy =new PerforRpcProxy(url);

        HelloService helloService = rpcProxy.create(HelloService.class);

        long time = System.currentTimeMillis();
        String result = helloService.hello("World");
        System.out.println("get result："+result);

        long t1=System.currentTimeMillis() - time;
        LOGGER.info("time: {}ms",t1);
//        Person p=new Person();
//        p.setName("Test");
//        p.setAge(123);
//        Person fa=new Person();
//        fa.setName("father");
//        fa.setAge(55);
//        p.setFa(fa);
//        List<String>list=new ArrayList<>();
//        list.add("asdasd");
//        list.add("a122");
//        p.setList(list);
//        Person p1=helloService.helloPerson(p);
//        System.out.println(p1);
//        long time = System.currentTimeMillis();
//        for(int i=0;i<1000;i++){
//            helloService.helloPerson(p);
//        }
//        long t1=System.currentTimeMillis() - time;
//        LOGGER.info("time: {}ms",t1);
    }
}
