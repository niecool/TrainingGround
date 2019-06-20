package com.jd.cms.test.findingAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019-06-17 20:01
 */
public class bubbleSort {

//        @Test
//        public void test(){
//            int[ ] a = {2,1,3,8,6,5,9} ;
//            sort(a);
//            for(int i = 0 ; i<a.length; i++){
//                System.out.print(a[i]+"");
//            }
//        }
//
//    /**
//     * 冒泡排序
//     */
//    private void sort(int[] a){
//            int temp = 0;
//            for(int i = 0; i<a.length-1; i++){
//                for(int j = 0; j<a.length -1 -i; j++){//最大的冒泡到下面去
//                    if(a[j]>a[j+1]){
//                        temp = a[j+1];
//                        a[j+1] = a[j];
//                        a[j] = temp;
//                    }
//                }
//            }
//    }


    @Test
    public void test(){
        int[] a = {5,3,7,1,9,2,0,4};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a){
        int temp = 0;
        //外层循环，每次找出排除最大值剩下值的循环冒泡。
        for(int i = 0; i < a.length-1; i++){
            //内层循环，冒泡的主体。
            for(int j = 0; j < a.length-1-i; j++){
                if(a[j]>a[j+1]){
                    //swap
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }


}
