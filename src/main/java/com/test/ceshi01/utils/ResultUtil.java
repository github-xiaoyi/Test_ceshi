package com.test.ceshi01.utils;

import com.test.ceshi01.entity.Result;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 工具类(插入数据成功或者失败验证返回信息)，解决代码的重复性
 */
public class ResultUtil {
    //插入成功有返回对象参数
    public static Result success(Integer code,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg("成功");
        result.setData(object);
        return  result;
    }

    public static Result success(Integer code){
        return  success(code,null);
    }

    //插入失败
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
