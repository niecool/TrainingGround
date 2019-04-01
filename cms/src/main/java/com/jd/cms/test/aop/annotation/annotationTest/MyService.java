package com.jd.cms.test.aop.annotation.annotationTest;

/**
 * @author zhaochengye
 * @date 2019/3/28 11:04
 */
public class MyService {

    /**
     *
     */
    @LogLevel(value = LogLevel.Level.ERROR)
    public void doSomething(){
        System.out.println("doSomething");
    }

    /**
     *
     */
    @LogLevel(value = LogLevel.Level.INFO)
    public void doSomethingElse(){
        System.out.println("doSomethingElse");
    }
}
