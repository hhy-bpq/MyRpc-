package com.jsontest;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/28
 */
public class T1 {
    public static void main(String[] args) throws InterruptedException {
        Object obj=new Object();
        synchronized (obj){
            while (true){
                long t1=System.currentTimeMillis();
                long time=1000*60;
                obj.wait(time);
                System.out.println(System.currentTimeMillis()-t1);
            }
        }
    }
}
