package com.test.ceshi01.handler;

import com.test.ceshi01.entity.Result;
import com.test.ceshi01.exception.GirlException;
import com.test.ceshi01.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * girl统一捕获异常处理
 */
@ControllerAdvice  //拦截异常并统一处理
public class GrilExceptionHandler {

    private  final  static Logger logger = LoggerFactory.getLogger(GrilExceptionHandler.class);

    @ExceptionHandler(value = Exception.class) //设置捕获哪一类异常，捕获Exception异常
    @ResponseBody     //返回json数据，因上面没有@RestController，此处使用@ResponseBody
    public Result girlHander(Exception e){
        if(e instanceof GirlException){ //判断异常是否是自己定义异常
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
