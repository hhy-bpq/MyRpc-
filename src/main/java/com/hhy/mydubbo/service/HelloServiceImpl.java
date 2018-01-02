package com.hhy.mydubbo.service;


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

    @Override
    public void test1() {
        int i=0;
        int j=1;
        int a=j/i;
    }

    @Override
    public void test2() throws Exception {

    }

}
