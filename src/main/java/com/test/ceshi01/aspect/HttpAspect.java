package com.test.ceshi01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

@Aspect //标示类为一个切面AOP，供spring容器读取
@Component //交由spring容器管理
public class HttpAspect {

    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //调用com.test.ceshi01.controller.GirlController方法girlList，任何参数都会被拦截
    //@Pointcut 定义一个公用的方法
    @Pointcut("execution(public * com.test.ceshi01.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBeFore(JoinPoint joinPoint){
        logger.info("before");
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("id={}",request.getRemoteAddr());
        //类方法 需要传入对象 Joinpoint
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("after");
    }
//11
    //方法正常执行后，获取返回信息
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
