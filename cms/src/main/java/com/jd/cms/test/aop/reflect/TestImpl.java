package com.jd.cms.test.aop.reflect;

import java.lang.reflect.Proxy;

/**
 * @author zhaochengye
 * @date 2019/3/27 21:55
 */
public class TestImpl implements Test{

    public void doSomething() {
        System.out.println("doSomething");
    }

    public void doSomethingElse() {
//        ClassLoader cl = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
//            }
//        };
//        try {
//            cl.loadClass("");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.out.println("doSomethingElse");
    }

    public static void  main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test test = new TestImpl();
//        new InvokeHandler(test);
        Class c = Class.forName("TestImpl");

        Test t = (Test)c.newInstance();

        Test proxy = (Test) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Test.class},new InvokeHandlerTest(test));
        proxy.doSomething();
        proxy.doSomethingElse();
//        Thread.currentThread().getContextClassLoader().loadClass("as");
    }

}
