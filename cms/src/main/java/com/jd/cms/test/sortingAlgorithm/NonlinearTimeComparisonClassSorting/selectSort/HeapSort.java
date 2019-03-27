package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.selectSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaochengye
 * @date 2019/3/7 20:11
 */
public class HeapSort implements SortAbstract {

    private Integer len;
    public void sort(Integer[] arr) {

        buildMaxHeapify(arr);

        for (int i = arr.length-1; i > 0; i--) {
            swap(arr,0,i);
            len --;
            heapify(arr,0);

        }

    }

    private void buildMaxHeapify(Integer[] arr){
        len = arr.length;
        for (int i = len/2; i >= 0 ; i--) {
            heapify(arr,i);
        }
    }

    private void heapify(Integer[] arr, Integer i) {
        Integer left = 2*i+1 ;
        Integer right = 2*i +2;
        Integer largest = i;

        if (left < len && arr[left] > arr[i]) {
            largest = arr[left];
        }

        if(right < len && arr[right]> arr[i]){
            largest = arr[right];
        }

        if(largest != i){
            swap(arr,i,largest);
            heapify(arr,largest);
        }

    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        while(true){
            if(input.equals("123")){
                s=input.nextLine();
                break;
            }else{
                System.out.println("请输入正确密码");
            }
        }

        System.out.println("===============");
//        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
//        HeapSort heapSort = new HeapSort();
//        heapSort.sort(a);
//        System.out.println(Arrays.asList(a));
    }
}
