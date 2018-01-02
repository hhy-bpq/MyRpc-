package com.hhy.mydubbo.test;

import com.hhy.mydubbo.server.RpcServer;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public class ServiceTest2 {
    public static void main(String[] args) {
        try {
            String url="127.0.0.1:9030";
            new RpcServer(url).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
