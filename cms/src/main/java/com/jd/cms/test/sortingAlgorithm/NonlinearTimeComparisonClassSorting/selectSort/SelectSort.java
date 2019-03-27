package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.selectSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/3/7 15:18
 */
public class SelectSort implements SortAbstract {
    public void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Integer nextIndex = i + 1;
            Integer minNum = arr[i];//初始值
            Integer flag = i;
            while (nextIndex < arr.length) {
                if (arr[nextIndex] < minNum) {
                    minNum = arr[nextIndex];
                    flag = nextIndex;
                }
                nextIndex++;
            }
            arr[flag] = arr[i];
            arr[i] = minNum;
            System.out.println(Arrays.asList(arr));

        }
    }

    public static void main(String[] args) {
        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
        SelectSort selectSort = new SelectSort();
        selectSort.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
