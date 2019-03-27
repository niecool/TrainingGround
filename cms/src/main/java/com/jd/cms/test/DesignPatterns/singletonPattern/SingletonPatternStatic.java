package com.jd.cms.test.DesignPatterns.singletonPattern;

/**
 * @author zhaochengye
 * @date 2019/3/8 08:55
 */
public class SingletonPatternStatic {

    private static volatile TestService instance= new TestService();

    public static TestService getInstance(){
        return instance;
    }


}
