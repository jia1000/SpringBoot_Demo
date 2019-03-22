package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// 声明是一个Spring管理配置Bean
@Configuration
// 声明这是一个切面类
@Aspect
public class AOPConfig {
    // @Around : 声明一个表达式，描述要植入的目标的特性。
    // @within : 声明目标类型带有注解，其注解类型为.Controller。意味着，Controller方法被调用是，都会执行方法@Around，即，simpleAop函数
    @Around("@within(org.springframework.stereotype.Controller) ")
    // simpleSop函数，是用来植入的代码。
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));
            // 调用原有的方法
            Object o = pjp.proceed();
            System.out.println("return : " + o);

            return o;

        } catch (Throwable e){
            throw e;
        }
    }

}
