package com.jd.cms.test.concurrentTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaochengye
 * @date 2019/3/25 13:41
 */
public class SyncAndLockTest {

    private ReentrantLock lock = new ReentrantLock(true);



    public void countNum(int count){
        System.out.println(count++);
    }

    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(){
//               @Override
//                public void run(){
//
//
//               }
//
//            };
//            t.setName("thread-"+i);
//            t.start();

//            Runnable t = new Runnable() {
//                public void run() {
//                    countNum(i);
//                }
//            }

//            Runnable r = new Runnable() {
//                public void run() {
//                    count
//                }
//            };
            RunnableTest test = new RunnableTest(i);
            executorService.execute(test);

        }
    }


}
