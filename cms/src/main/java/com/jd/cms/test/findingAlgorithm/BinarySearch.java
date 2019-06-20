package com.jd.cms.test.findingAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019-06-17 17:04
 */
public class BinarySearch {

//    /**
//     *
//     */
//    @Test
//    public void test() {
//        int[] a = {2, 4, 6, 8, 9, 10, 234, 1234};
//        System.out.println(a[0]);
//        int target = 1234;
//        System.out.println(sort(0, a.length - 1, a, target));
//
//    }
//
//
//    /**
//     *二分查找
//     */
//    public int sort(int left, int right, int[] a, int target) {
//        if (left <= right) {
//            if (a[left] == a[right]) {
//                return a[left] == target ? target : -1;
//            } else {
//                int middle = (left + right) / 2;//这里的1是做向下取整的补偿
//                if (a[middle] == target) {
//                    return middle;
//                }
//                if (a[middle] > target) {
//                    return sort(left, middle-1, a, target);//这里的-1和+1是为了收敛的作用，否则(left+right)/2两端总有一边没法继续收敛，其次也是可以每次少比较一个元素。
//                }
//                return sort(middle+1, right, a, target);
//            }
//        } else {
//            return -1;
//        }
//    }



//    @Test  //测试类
//    public void test(){
//        int[] a = {1,3,5,7,9,13,14,15,1234,3456,345678};
//        System.out.println(Arrays.toString(a));
//        System.out.println(sort(0,a.length-1,a,5));
////for(int i = 0; i < a.length-1; i++){
////System.out.print
////}
//    }
//
//    private int sort(int left, int right, int[] a, int target){
////1.校验右比左大
//        if(left > right) return -1;
//
////2.判断是否相等
//        if(left == right){
//            return a[left]==target?left:-1;
//        }
//
////3.右边比左边大
//        int middle = (left+right)/2;
//        if(a[middle]<target){
//            return sort(middle+1,right,a,target);
//        }else if(a[middle]>target){
//            return sort(left,middle-1,a,target);
//        }else{
//            return middle;
//        }
//    }








    @Test
    public void test(){
        int[] a = {1,2,3,4,5,6,7,8,9,10,13,15,16,17};
        //        search(a, 15, 0, a.length-1);
        System.out.println(search(a, 15, 0, a.length-1));
    }

    private int search(int[] a, int target, int left, int right){
        //1.如果细分到一个的时候直接判断返回。
        if(left == right){
            return a[left] == target ? left : -1;
        }
        //2.如果细分还有很多的时候，需要继续细分。
        if(left < right){
            int middle = (left + right)/2;
            if(a[middle] == target){
                return middle;
            }else if(a[middle] < target){
                return search(a, target, middle+1, right);
            }else{
                return search(a, target, left, middle-1);
            }
        }
        return -1;
    }

    public static class Inner{}

}
