package com.jd.cms.test.CollectionTest;

import sun.misc.Unsafe;

/**
 * @author zhaochengye
 * @date 2019/3/7 21:33
 */
public class HashTest {

    public static void main(String[] args) {
        Object o = "1";
        Object o1 = 1;
        Object o2 = 5;
        Object o3 = "A";

        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());
    }
}
