package com.jsontest;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/28
 */
public class Res {
    private Object ex;
    private String type;
    private Long id;
    private Object result;
    private boolean isOk=true;
    public Res(){

    }
    public Res(long id ){
        this.id=id;
    }
    public Object getEx() {
        return ex;
    }

    public void setEx(Object ex) {
        this.ex = ex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }
}
