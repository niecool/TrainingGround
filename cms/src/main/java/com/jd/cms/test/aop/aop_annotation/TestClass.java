package com.jd.cms.test.aop.aop_annotation;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhaochengye
 * @date 2019/4/1 14:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class TestClass {

    @Resource
    private MyService myService;

    /**
     *
     */
    @Test
    public void test(){
        myService.doSomething();
        myService.doSomethingElse();
    }
}
