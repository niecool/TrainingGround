package com.jd.cms.test;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019-06-19 09:29
 */
public class MyList<D> {

    private int size;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    transient Object[] elementData;

    public MyList(){
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(D d){
        //确保容量足够
        ensureCapacity(size++);
        //添加数据到数组
        elementData[size++] = d;
        //返回成功，之前返回的都是false；
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        //1.数组为空，那么就要初始化。
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);//有助于提高初始1.5倍扩张的效率。
        }
        //2.如果数组容量不够，那么就扩容，然后返回。
        if(elementData.length < minCapacity){
            expandCapacity(minCapacity);
        }

    }

    private void expandCapacity(int needCapacity) {
        int oldCapacity = elementData.length;
        int newLength = oldCapacity + oldCapacity >> 1;//简单扩容

        if(newLength < needCapacity){//不够就按照需求来
            newLength = needCapacity;
        }

        if(newLength > MAX_CAPACITY){//校验范围
            if (newLength < 0) // overflow
                throw new OutOfMemoryError();
            newLength = Integer.MAX_VALUE;
        }
        Arrays.copyOf(elementData,newLength);
    }

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
       Boolean a =  list.add(2);
        System.out.println(a.booleanValue());

    }
}
