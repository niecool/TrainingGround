package com.jd.cms.test.tx.spring_tx;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaochengye
 * @date 2019/4/2 10:22
 */
public class TestClass {

    /**
     *
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
    public void test(){
        //doSomething

    }

}
