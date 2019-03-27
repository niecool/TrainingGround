package com.jd.cms.test.concurrentTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaochengye
 * @date 2019/3/8 14:31
 */
public class AtomOperate {

    private static volatile AtomicInteger atomicInteger;

    public static AtomicInteger getInstance(){
        if(atomicInteger == null){
            synchronized (AtomOperate.class){
                if(atomicInteger == null){
                    atomicInteger = new AtomicInteger(1);

                }
            }
        }
        return atomicInteger;
    }

}
