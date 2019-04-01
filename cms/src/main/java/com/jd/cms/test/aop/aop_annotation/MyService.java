package com.jd.cms.test.aop.aop_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaochengye
 * @date 2019/4/1 11:16
 */

@Component("myService")
public class MyService {

    /**
     *
     */
    @AuthLevel(name = AuthLevel.Value.add)
    public void doSomething(){
        System.out.println("doSomething!");
    }

    /**
     *
     */
    @AuthLevel(name= AuthLevel.Value.delete)
    public void doSomethingElse(){
        System.out.println("doSomethingElse");
    }



}
