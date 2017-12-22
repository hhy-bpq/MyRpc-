package com.hhy.mydubbo.protobuf.bean;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/21
 */
public class Request {
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
}
