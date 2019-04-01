package com.jd.cms.test.aop.annotation.annotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhaochengye
 * @date 2019/3/28 11:12
 */
public class annotationTest {
    /**
     * 根据目标类获取方法注解。
     *
     *
     * @param args
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws NoSuchMethodException {
        Class clazz = MyService.class;
        Method m1 = clazz.getMethod("doSomething");
        Annotation[] ans = m1.getAnnotations();
        for(Annotation a:ans){
            System.out.println(a.annotationType());
        }
        System.out.println();
    }
}
