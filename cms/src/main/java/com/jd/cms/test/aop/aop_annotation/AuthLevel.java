package com.jd.cms.test.aop.aop_annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaochengye
 * @date 2019/4/1 11:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
public @interface AuthLevel {

     enum Value{
        read,add,modify,delete
    }

    Value name() default Value.add;
}
