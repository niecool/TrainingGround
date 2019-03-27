package com.jd.cms.test.concurrentTest.OrderExecuteDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaochengye
 * @date 2019/3/25 15:30
 */
public class MainService {





    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            final String str = "";
            Runnable task = new Runnable() {
                public void run() {
                    doSomething(str);
                }
            };

        }
    }


    public static void doSomething(String a){
        System.out.println(a);
    }

}
