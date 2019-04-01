package com.jd.cms.test.aop.aop_xml;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhaochengye
 * @date 2019/4/1 16:13
 */
@Component("xmlAdvisor")
public class XmlAdvisor implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("=========before======");
    }

}
