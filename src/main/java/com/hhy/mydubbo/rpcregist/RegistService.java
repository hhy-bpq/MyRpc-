package com.hhy.mydubbo.rpcregist;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/7
 */
public interface RegistService {

    /**
     * 注册
     * @param url
     * @param name
     * @return
     */
    boolean regist(String url, String name);

    /**
     * 清除
     * @param name
     * @return
     */
    long clean(String name);

    /**
     * 根据 服务名 获取连接地址
     * @param name
     * @return
     */
    String getUrl(String name);

}
