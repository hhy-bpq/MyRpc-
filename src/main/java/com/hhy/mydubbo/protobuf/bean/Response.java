package com.hhy.mydubbo.protobuf.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/21
 */
public class Response {

    private Object result;
    private String resultType;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public static void main(String[] args) {
        class Test{
            String name;
            int  age;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
        Response response=new Response();
        List<Object> l=new ArrayList<>();
        l.add("asdas");
        l.add(1);
        Test p=new Test();
        p.setAge(12);
        p.setName("asd");
        l.add(p);
        response.setResult(l);
        String js=JSONObject.toJSONString(response);
        Response rp2= JSONArray.parseObject(js,Response.class);
        System.out.println(rp2.getResult());
        List<Object> res= (List<Object>) rp2.getResult();
    }
}
