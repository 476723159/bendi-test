package com.itheima.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* *..*.*(..))")
    private void pt1(){};

    @Before("pt1()")
    public void print(){
        System.out.println("logger类中的打印日志方法执行了");
    }
}
