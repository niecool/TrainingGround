package com.jd.cms.test.aop.DynamicProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhaochengye
 * @date 2019/3/31 09:06
 */
public class Test {
    /**
     * 代理是将自定义代码添加到目标代码周围。
     *
     * 自定义代码：实现interceptor
     * 添加到周围：使用asm包生成代理类，将interceptor代码放到伪方法周围，带哦用superMethod执行父类方法。
     *
     * Aop就是将规则写入生成类的执行过程中适应的规则。这些规则有两种注入方式（注解、xml配置）。
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new AMethodInterceptor());
        A a = (A)enhancer.create();
        a.hello();
    }
}
