package com.zcy.cms.redis;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

public class redis {

    //    public static void main(String[] args) {
    private static ShardedJedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        // 集群
        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("113.209.26.156", 6379);
        jedisShardInfo1.setPassword("19940825lgg");
        List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
        list.add(jedisShardInfo1);
        pool = new ShardedJedisPool(config, list);
    }

    public static void main(String[] args) {
        ShardedJedis jedis = pool.getResource();
        String keys = "zcy2";
        String vaule = jedis.set(keys, "2");
        System.out.println(vaule);
    }


//        //1.链接redis服务
//        Jedis jedis = new Jedis("113.209.26.156",);
//        System.out.println("Connection to server sucessfully");
//        //查看服务是否运行
//        System.out.println("Server is running: "+jedis.ping());
//    }
}
