package com.jd.cms.test.DesignPatterns.singletonPattern;

/**
 * @author zhaochengye
 * @date 2019/3/8 09:10
 */
public class SingletonPatternLazyLoad {

    private static TestService instance;
    private static InnerClass innerClassInstance;

    //1.方法锁 注意成员变量和方法都要求是static
    public static synchronized  TestService getInstance(){
        if(instance == null){
            instance = new TestService();
        }
        return instance;
    }

    //2.两次检查锁
    public static TestService getInstanceByDoubleLock(){
        if(instance == null){
                synchronized (TestService.class){
                    if(instance == null){
                        instance = new TestService();
                    }
                }
        }

        return instance;
    }

    //3.使用静态内部类
    public static InnerClass getInstanceByStaticInnerClass(){
        return InnerClass.innerClassInstance;
    }

    public static class  InnerClass{
        private static InnerClass innerClassInstance = new InnerClass();
    }


}
