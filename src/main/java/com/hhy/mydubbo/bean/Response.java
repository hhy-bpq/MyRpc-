package com.hhy.mydubbo.bean;

import java.io.Serializable;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/13
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 4560695987432388537L;
    private Long id;
    private String errorMsg;
    private Object result;
    public Response(Long id){
        this.id=id;
    }
    //是否是事件
    private boolean event = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }
}
