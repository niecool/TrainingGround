package com.jd.cms.test.concurrentTest.OrderExecuteDemo;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaochengye
 * @date 2019/3/25 15:30
 */
public class ControlService {
    private volatile LinkedList<Long> invokeTimeList = new LinkedList<Long>();
    private volatile Integer sizeLimit;
    private volatile Long timeRangeLimit;
    private ReentrantLock reentrantlock = new ReentrantLock(true);

    public synchronized boolean flowControlOverLoad(Long invokeTime){
        boolean result = false;//默认流量状态不超标
        invokeTimeList.add(invokeTime);
        if(invokeTimeList.size()==sizeLimit && (invokeTimeList.getLast()-invokeTimeList.getFirst()) > timeRangeLimit){
            invokeTimeList.removeFirst();
        }
        if(invokeTimeList.size() >= sizeLimit){
            return true;
        }
        return result;
    }

    public boolean flowControlOverLoadLock(Long invokeTime){
//        reentrantlock.lock();
        boolean result = false;//默认流量状态不超标
        invokeTimeList.add(invokeTime);
        if(invokeTimeList.size()==sizeLimit && (invokeTimeList.getLast()-invokeTimeList.getFirst()) > timeRangeLimit){
            invokeTimeList.removeFirst();
        }
        if(invokeTimeList.size() >= sizeLimit){
            return true;
        }
//        reentrantlock.unlock();
//        System.out.println(invokeTime);

        System.out.println(Thread.currentThread().getName());
        return result;
    }

    public ControlService(Long timeRangeLimit, Integer sizeLimit){
        this.timeRangeLimit=timeRangeLimit;
        this.sizeLimit = sizeLimit;
    }

}
