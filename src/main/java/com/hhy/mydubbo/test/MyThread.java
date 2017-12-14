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
class MyThread extends Thread{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);
        private  int index;
        MyThread(int index){
            this.index=index;
        }
        @Override
        public void run() {
            String url="127.0.0.1:9020";
            RpcProxy rpcProxy =new RpcProxy(url);
            HelloService helloService = rpcProxy.create(HelloService.class);
            Person p=new Person();
            p.setName("name:"+index);
            p.setAge(123);
            Person fa=new Person();
            fa.setName("father");
            fa.setAge(55);
            p.setFa(fa);
            List<String>list=new ArrayList<>();
            list.add("asdasd");
            list.add("a122");
            p.setList(list);
            long time = System.currentTimeMillis();
            Person p1=helloService.helloPerson(p);
            LOGGER.info("time: {}ms", System.currentTimeMillis() - time);
//            System.out.println(p1);
        }
    }