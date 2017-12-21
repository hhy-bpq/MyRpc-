package com.hhy.mydubbo.test;

import com.hhy.mydubbo.protobuf.server.ProtoServer;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/20
 */
public class ProtoServerTest {
    public static void main(String[] args) {
        try {
            String url="127.0.0.1:9030";
            ProtoServer server=new ProtoServer(url);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
