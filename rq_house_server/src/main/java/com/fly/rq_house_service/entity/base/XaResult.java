package com.fly.rq_house_service.entity.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/18 0018.
 */
public class XaResult<T> implements Serializable{

    private int code;

    private String msg;

    private T data;


    public XaResult(T data) {
        this.code = 1;
        this.data = data;
    }

    public XaResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public XaResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
