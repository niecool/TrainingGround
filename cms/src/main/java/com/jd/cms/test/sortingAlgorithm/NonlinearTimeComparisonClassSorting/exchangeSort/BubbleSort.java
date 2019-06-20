package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.exchangeSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;
import org.apache.commons.collections.ListUtils;

import java.util.*;


/**
 * @author zhaochengye
 * @date 2019/3/6 17:23
 */
public class BubbleSort implements SortAbstract {
    public void sort(Integer[] arr) {

//        for(int i=0;i<arr.length;i++){//不知道是什么排序
//            for(int j=0;j<arr.length;j++){
//                    if(arr[i]<arr[j]){
//                        Integer temp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = temp;
//                    }
//            }
//        }
        Integer len = arr.length;
        Integer temp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1; j++) {//todo len-1-i才是真正理解冒泡排序
                if(arr[j]<arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字

//        Arrays.sort(a, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                Integer a = (Integer)o1;
//                Integer b = (Integer)o2;
//                if(a > b){
//                    return 1;
//                }else if(a == b){
//                    return 0;
//                }
//                return -1;
//            }
//        });

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
