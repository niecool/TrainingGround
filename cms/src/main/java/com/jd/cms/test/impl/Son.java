package com.jd.cms.test.impl;

/**
 * @author zhaochengye
 * @date 2019/3/27 11:32
 */
public class Son extends Father {
    public static void main(String[] args) {
        Son s = new Son();
        Son s1 = new Son();
        System.out.println(s.getA());
        s.setA(2);
        System.out.println(s1.getA());
        System.out.println(s.getA());
    }
}
