package com.jd.cms.test.concurrentTest;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Semaphore;

/**
 * @author zhaochengye
 * @date 2019/3/12 19:57
 */
public class SemaphoreTest extends Thread{

    private  Semaphore semaphore;
    public SemaphoreTest(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    private void test(){
        if(semaphore.getQueueLength()>3){
            System.out.println("=====================zcy=============================");
        }
        try {
            semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
            System.out.println(semaphore.availablePermits());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public void run() {
        test();
    }

    public static void main(String[] args) {
         Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 110; i++) {
            SemaphoreTest semaphoreTest = new SemaphoreTest(semaphore);
            semaphoreTest.setName("Thread"+i);
            semaphoreTest.start();
        }





    }
}
