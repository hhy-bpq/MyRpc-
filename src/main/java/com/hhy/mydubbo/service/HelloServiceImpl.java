package com.hhy.mydubbo.service;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
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
