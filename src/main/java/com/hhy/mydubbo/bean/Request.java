package com.hhy.mydubbo.bean;

import java.io.Serializable;

/**
 * 自定义协议request 内容体
 * @Author：huanghaiyun
 * @Date:2017/12/13
 */
public class Request implements Serializable{
    private static final long serialVersionUID = -3489984679839149018L;
    //请求的id
    private Long id;
    //方法名
    private String methodName;
    //完整类路径
    private String path;
    //方法的参数
    private Object[] params;
    //方法的参数类型
    private Class<?>[] parameterTypes;
    //版本
    private String version;

    //是否需要有返回值
    private boolean twoWay = true;
    //是否是事件
    private boolean event = false;
    public  Request(){
        this.id=1L;
    }
    public  Request(Long id){
        this.id=id;
    }
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTwoWay() {
        return twoWay;
    }

    public void setTwoWay(boolean twoWay) {
        this.twoWay = twoWay;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }
}
