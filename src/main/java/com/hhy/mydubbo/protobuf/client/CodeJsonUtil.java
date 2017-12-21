package com.hhy.mydubbo.protobuf.client;

import com.alibaba.fastjson.JSONObject;
import com.hhy.mydubbo.service.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/20
 */
public class CodeJsonUtil {
    public static String beanToJson(Object obj){
        StringBuilder builder=new StringBuilder();
        Field[] fields= obj.getClass().getDeclaredFields();
        for(Field f:fields){
//            f.getClass().i
            System.out.println(f);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Person p=new Person();
        String name="Test/n/m\\n\\m\n/r{[]:''@3124!@#$%^&&*}<>?\\///\\as sa";
        p.setName(name);
        p.setAge(123);
        Person fa=new Person();
        fa.setName("father");
        fa.setAge(55);
        p.setFa(fa);
        List<String> list=new ArrayList<>();
        list.add("asdasd");
        list.add("a122");
        p.setList(list);
        System.out.println(p.getName());
        String s=JSONObject.toJSONString(p);
        System.out.println(JSONObject.toJSONString(p));
        System.out.println(s);
        Person p2=JSONObject.parseObject(s,Person.class);
        System.out.println(p2.getName());
        System.out.println(p2.getName().equals(name));
        System.out.println(JSONObject.toJSONString(p2));
//        beanToJson(p);
    }

}
