package com.jd.cms.test.aop.aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author zhaochengye
 * @date 2019/4/1 15:11
 */
@Component("xmlAuthLevel")
public class XmlAuthLevel {

    /**
     *around
     */
    public void runOnAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("=========记录日志开始===============");
        point.proceed();
        System.out.println("=========记录日志结束===============");
    }
}
