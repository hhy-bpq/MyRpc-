package com.hhy.mydubbo.test;

import com.hhy.mydubbo.protobuf.server.ProtoServer;
import com.hhy.mydubbo.protobuf.server.ProtoServer2;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/20
 */
public class ProtoServerTest2 {
    public static void main(String[] args) {
        try {
            String url="127.0.0.1:9030";
            ProtoServer2 server=new ProtoServer2(url);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
