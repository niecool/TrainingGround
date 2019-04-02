package com.jd.cms.test.tx.jdbc.oracle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/4/1 21:28
 */
public class Test {

    public static void main(String[] args) {
//        Object o = new ArrayList<Integer>();
//        System.out.println(o instanceof ArrayList);
//        System.out.println(o instanceof Arrays);
        System.out.println(new Integer(5).hashCode());
        System.out.println("a".hashCode());
        Object o =new Object();
        System.out.println(o.hashCode());
        System.out.println(o.hashCode());
        System.out.println(o.hashCode());
    }
    //1751075886
}
