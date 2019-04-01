package com.jd.cms.test.aop.annotation.annotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaochengye
 * @date 2019/3/28 11:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
public @interface LogLevel {
    enum Level{
        INFO,EXCEPTION,ERROR
    }

    Level value() default Level.INFO;


}
