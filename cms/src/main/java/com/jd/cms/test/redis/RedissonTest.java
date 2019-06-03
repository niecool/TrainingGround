package com.jd.cms.test.redis;

import org.junit.Test;
import org.redisson.api.RBuckets;
import org.redisson.api.RedissonClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

/**
 * @author zhaochengye
 * @date 2019-05-29 15:35
 */
public class RedissonTest {
    @Test
    public void test() {
        RedissonClient client = RedisUtils.getInstance().getRedisson("192.168.57.75","6379");
        String mylock = "lock";
        Lock lock = client.getLock(mylock);
        lock.lock();
            lock.unlock();


    }
}
