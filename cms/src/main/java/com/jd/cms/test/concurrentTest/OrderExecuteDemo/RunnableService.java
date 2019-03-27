package com.jd.cms.test.concurrentTest.OrderExecuteDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaochengye
 * @date 2019/3/25 15:31
 */
// todo
public class RunnableService implements Runnable {
    private String name;
    private ControlService controlService = new ControlService(1L,2);
    private ReentrantLock lock = new ReentrantLock(true);
    private ExecutorService executorService = Executors.newFixedThreadPool(8);

    public  RunnableService(String name){
        this.name = name;
    }
    public void run() {
        doSomething();
    }

    public void doSomething(){
        lock.lock();
        try {
            boolean flag = controlService.flowControlOverLoadLock(System.currentTimeMillis());
            if(!flag){
                RunnableService runnableService = new RunnableService("Thread-"+"====");
                executorService.execute(runnableService);
            }else{
                System.out.println("短暂超时=======");
            }
            System.out.println(name + "doing something!");

        }catch (Exception e){
            //log
        }finally {
            lock.unlock();
        }

    }
}
