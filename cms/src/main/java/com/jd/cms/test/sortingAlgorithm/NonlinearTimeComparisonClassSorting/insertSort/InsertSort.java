package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.insertSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/3/7 12:57
 */
public class InsertSort implements SortAbstract {

    public void sort(Integer[] arr) {
        Integer preIndex, current;
        for (int i = 0; i < arr.length; i++) {
            current = arr[i];
//            Integer flag = i - 1;
//            for (int j = i - 1; j >= 0; j--, flag--) {
//                if (arr[j] < current) { //替换当前位置
//                    arr[j + 1] = current;
//                    break;
//                } else {//往后挪位置
//                    arr[j + 1] = arr[j];
//
//                }
//
//            }
//            arr[flag+1] = current;

            preIndex = i - 1;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;

        }
    }

    public static void main(String[] args) {
        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
        InsertSort insertSort = new InsertSort();
        insertSort.sort(a);
        System.out.println(Arrays.asList(a));
    }
}
