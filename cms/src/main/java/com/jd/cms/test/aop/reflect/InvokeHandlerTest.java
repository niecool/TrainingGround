package com.jd.cms.test.aop.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaochengye
 * @date 2019/3/28 09:53
 */
public class InvokeHandlerTest implements InvocationHandler {
    private Object proxyed;

    public InvokeHandlerTest(Object proxyed){
        this.proxyed = proxyed;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行自定义handler");
        return method.invoke(proxyed,args);
    }


}
