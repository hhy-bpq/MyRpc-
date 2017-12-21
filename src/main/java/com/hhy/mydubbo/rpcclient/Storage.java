package com.hhy.mydubbo.rpcclient;

import com.hhy.mydubbo.bean.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 仓库
 * @Author：huanghaiyun
 * @Date:2017/12/15
 */
public class Storage {
    private Response response=null;
    private Object obj=new Object();
    private long timeOut=1000*5;//5秒
    public Response get() throws TimeoutException {
        synchronized (obj){
            while(response==null){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(response==null){
                throw new TimeoutException();
            }
            return response;
        }
    }
    public void set(Response res) throws TimeoutException {
        synchronized (obj){
            this.response=res;
            obj.notifyAll();
        }
    }
}
