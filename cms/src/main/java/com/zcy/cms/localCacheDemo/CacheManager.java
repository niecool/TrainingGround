package com.zcy.cms.localCacheDemo;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

//一个本地的缓存Map

    private Map localCacheStore =new HashMap();

//一个私有的对象，非懒汉模式

    private static CacheManager cacheManager =new CacheManager();

//私有构造方法，外部不可以new一个对象

    private CacheManager(){

    }

//静态方法，外部获得实例对象

    public static CacheManager getInstance(){

        return cacheManager;

    }

//获得缓存中的数据

    public Object getValueByKey(String key){

        return localCacheStore.get(key);

    }

//向缓存中添加数据

    public void putValue(String key,Object value){
        localCacheStore.put(key,value);

    }

}

