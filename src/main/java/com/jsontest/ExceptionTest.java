package com.jsontest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.hhy.mydubbo.service.HelloService;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/28
 */
public class ExceptionTest {
    public static void main(String[] args) throws Exception {
        try {
            Proxy proxy=new Proxy();
            HelloService helloService=proxy.create(HelloService.class);
            helloService.test1();
        } catch (Exception e) {
//            System.out.println(e.toString());
//            e.printStackTrace();
            Res res=new Res();
            res.setEx(e.getCause());
            res.setType(e.getCause().getClass().getName());
            String tr=JSONObject.toJSONString(res);
//            throwable.printStackTrace();
            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            Res r2=JSONObject.parseObject(tr,Res.class);
            Throwable t=(Throwable)r2.getEx();
            t.printStackTrace();

        }

    }
}
