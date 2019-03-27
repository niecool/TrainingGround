package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.exchangeSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/3/6 17:08
 */
public class QuickSort implements SortAbstract {


    public static void main(String[] args) {
        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
//        Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};//13个数字
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        System.out.println(Arrays.asList(a));
    }


    public void sort(Integer[] arr) {
        this.sortRecursive(arr, null, null);
    }

    private void sortRecursive(Integer[] arr, Integer left, Integer right) {
        Integer indexPartition;
        left = left == null ? 0 : left;
        right = right == null ? arr.length - 1 : right;
        if (left < right) {
            indexPartition = partition(arr, left, right);
            sortRecursive(arr, left, indexPartition - 1);
            sortRecursive(arr, indexPartition + 1, right);

        }

    }

    private Integer partition(Integer[] arr, Integer left, Integer right) {
        Integer pivot = left;
        Integer index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
