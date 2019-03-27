package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.mergingSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;
import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/3/7 15:34
 */
public class DoubleMergingSort implements SortAbstract {
    public void sort(Integer[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    public void mergeSort(Integer [] a,Integer start,Integer end){
        if(start<end){//当子序列中只有一个元素时结束递归
            Integer mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }


    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge(Integer []a,Integer left,Integer mid,Integer right){
        Integer []tmp=new Integer[a.length];//辅助数组
        Integer p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }

        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (Integer i = left; i <=right; i++)
            a[i]=tmp[i];
    }



    public static void main(String[] args) {
        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
        DoubleMergingSort doubleMergingSort = new DoubleMergingSort();
        doubleMergingSort.sort(a);

        System.out.println(Arrays.asList(a));
    }
}
