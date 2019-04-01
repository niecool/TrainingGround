package com.jd.cms.test.aop.DynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaochengye
 * @date 2019/3/31 09:00
 */
public class AMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start proxy!");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("end proxy!");
        return object;
    }
}
