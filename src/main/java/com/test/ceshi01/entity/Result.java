package com.test.ceshi01.entity;

/**
 * 类Result，处理外层返回结果的一致性，解决数据不统一问题（比如：成功返回json数据，不成功返回异常信息问题）
 */
public class Result<T> {
    //标记成功
    //标记成功
    private Integer code;
    //标记返回的信息，成功或者异常信息
    private String msg;
    //标记返回的结果数据，泛型
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
