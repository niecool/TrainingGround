package com.jd.cms.test.aop.aop_annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhaochengye
 * @date 2019/4/1 12:26
 */
@Aspect
@Component
public class AuthAspect {

    /**
     *
     */
//    @Pointcut("execution(public * MyService(..))")
    @Pointcut("execution(* *..MyService.*(..))")
    public void pointCutMethod(){
        System.out.println("pointCutMethod");
    }
    
    /**
     * 
     */
    @Before("pointCutMethod()")
    public void beforePointCutMethod(){
        System.out.println("beforePointCutMethod");
    }
    
    /**
     * 
     */
//    @Around("pointCutMethod()")
////    @Pointcut("execution(* com.jd.cms.test.aop.aop_annotation.*.aroundPointCutMethod())")
//    public String aroundPointCutMethod(){
//        System.out.println("aroundPointCutMethod");
//        return "1";
//    }
    
    /**
     * 
     */
//    @AfterReturning("aroundPointCutMethod()")
//    public void afterReturnPointCutMethod(){
//        System.out.println("afterReturnPointCutMethod");
//    }

}
