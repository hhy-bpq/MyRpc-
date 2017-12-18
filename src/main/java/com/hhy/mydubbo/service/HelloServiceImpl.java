package com.hhy.mydubbo.service;


import com.hhy.mydubbo.rpcserver.RpcService;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }

    @Override
    public Person helloPerson(Person person) {
        return person;
    }

}
