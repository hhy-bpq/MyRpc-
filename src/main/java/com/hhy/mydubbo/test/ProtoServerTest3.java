package com.hhy.mydubbo.test;

import com.hhy.mydubbo.protobuf.server.ProtoServer3;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/20
 */
public class ProtoServerTest3 {
    public static void main(String[] args) {
        try {
            String url="127.0.0.1:9030";
            ProtoServer3 server=new ProtoServer3(url);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
