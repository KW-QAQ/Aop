package com.example.demo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

//描述一个切面类，定义切面类的时候需要打上这个注解
@Aspect
//spring-boot配置类
@Configuration
public class TestAop {

    //定义一个切入点,使得我们可以控制通知什么时候执行。
    //作为切入点签名的方法必须返回void 类型
//    @Pointcut("execution(public * *(..))")
    @Pointcut("execution(* com.example.demo.service.impl.*(..))")
    public void execudeService(){

    }

    //通过连接点接入
    @Before( "execudeService()")
    public void before(){
        System.out.println("切面 before 执行结束，id =");
    }

    @Around( "execudeService()" )
    public Object around(ProceedingJoinPoint thisJoinPoint){
        System.out.println("切面执行了");
        try {
            System.out.println( ":a" );

            //proceed 方法用于决定，切入点调用的方法执不执行
            //如果注释，只执行到,:a
            //放开注释，将完整执行结束
            thisJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {

        }
        return null;
    }
}
