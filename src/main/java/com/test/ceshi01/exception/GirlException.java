package com.test.ceshi01.exception;

import com.test.ceshi01.enums.Resultenum;

/**
 *创建自己的捕获异常类
 */
//RunTimeException集成Exception，这里需要继承RunTimeException，
// 因为srping只对RunTimeException异常进行事务回滚，Exception异常不回滚
public class GirlException extends RuntimeException{
    private Integer code; //异常标示

    //构造方法，传递gode，mesage
    public GirlException(Resultenum resultenum) {
        super(resultenum.getMsg()); //父类实现
        this.code = resultenum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
