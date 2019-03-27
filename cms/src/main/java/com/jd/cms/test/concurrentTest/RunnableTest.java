package com.jd.cms.test.concurrentTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaochengye
 * @date 2019/3/25 15:06
 */
public class RunnableTest implements Runnable {
    private volatile Integer count;
    ReentrantLock lock = new ReentrantLock(true);
    public RunnableTest(Integer count){
        this.count = count;
    }

    public void run() {
//        lock.lock();
//        Long invokeTime = System.currentTimeMillis();
//        boolean flowControlOverLoaded = busyMailFlowControl.flowControlOverLoaded(invokeTime);
//        System.out.println(Thread.currentThread().getName()+"==="+count++);
//        Long invokeTime = System.currentTimeMillis();
//        lock.unlock();
    }

}
