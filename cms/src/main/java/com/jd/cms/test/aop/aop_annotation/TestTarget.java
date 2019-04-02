package com.jd.cms.test.aop.aop_annotation;

import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 * @author zhaochengye
 * @date 2019/4/2 21:08
 */
public class TestTarget {
    /**
     *
     */
    @Test
    public void test(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        JUnitCore.runClasses(TestTarget.class);
    }
}
