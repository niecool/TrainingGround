package com.jd.cms.test.sortingAlgorithm.NonlinearTimeComparisonClassSorting.exchangeSort;

import com.jd.cms.test.sortingAlgorithm.SortAbstract;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaochengye
 * @date 2019/3/6 17:08
 */
public class QuickSort implements SortAbstract {


//    public static void main(String[] args) {
//        Integer[] a = {13, 29, 6, 56, 27, 9, 86, 3, 4, 62, 8, 1, 7};//13个数字
////        Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};//13个数字
//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(a);
//        System.out.println(Arrays.asList(a));
//    }
//
//
//    public void sort(Integer[] arr) {
//        this.sortRecursive(arr, null, null);
//    }
//
//    private void sortRecursive(Integer[] arr, Integer left, Integer right) {
//        Integer indexPartition;
//        left = left == null ? 0 : left;
//        right = right == null ? arr.length - 1 : right;
//        if (left < right) {
//            indexPartition = partition(arr, left, right);
//            sortRecursive(arr, left, indexPartition - 1);
//            sortRecursive(arr, indexPartition + 1, right);
//
//        }
//
//    }
//
//    private Integer partition(Integer[] arr, Integer left, Integer right) {
//        Integer pivot = left;
//        Integer index = pivot + 1;
//        for (int i = index; i <= right; i++) {
//            if (arr[i] < arr[pivot]) {
//                swap(arr, i, index);
//                index++;
//            }
//        }
//        swap(arr, pivot, index - 1);
//        return index - 1;
//    }
//
//    private void swap(Integer[] arr, int i, int j) {
//        Integer temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }





//    @Test
//    public void test(){
//        int[] a = {5,3,7,1,9,2,0,4};
//        sort(0,a.length-1,a);
//        System.out.println(Arrays.toString(a));
//    }
//
//    private void sort(int left, int right, int[] a){
//        if(left<right){
////1.判断左边和右边是否已经递归到顶。
//            int index = partition(left,right, a);
////2.递归左边
//            sort(left,index-1,a);
////3.递归右边
//            sort(index+1,right,a);
//        }
//    }
//
//    private int partition(int left, int right, int[] a ){
////标兵默认第一个。
//        int piot = left;
////将小于piot的放在index左边，将大于piot放在index右边。
//        int index = left+1 ;
//        for(int i = index; i<=right; i++){
//            if(a[i] < a[piot]){
////index向右移动
//                swap(a,i,index);
//                index++;
//
//            }
//        }
////将piot放在合适的位置，然后返回index的位置。理论上是需要循环的，但是局部无序，只需要替换一个即可。
////for(int j=left; j<index;j++){
////a[j] = a[j+1];
////}
//        swap(a,piot,index-1);
//        return index-1;//todo 这里为什么减1，是因为我要返回真正的piot对应的点。
//    }
//
//    private void swap(int[] a, int i, int j){
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    public void sort(Integer[] arr) {

    }









    @Test
    public void test(){
        int[] a = {2,5,1,7,2,0,3,5};
        System.out.println(Arrays.toString(a));
        sort(0,a.length-1,a);
        System.out.println(Arrays.toString(a));
    }

    //1.找到中点，并排序好两边。
    //2.左边递归；
    //3.右边递归。
    public void sort(int left, int right, int[] a){
        if(left<right){
            int index = partition(left,right,a);
            sort(left,index-1,a);
            sort(index+1,right,a);
        }
    }

    private int partition(int left, int right, int[] a){
        int pivot = left;
        int index = pivot+1;
        for(int i = index;i<=right;i++){
            if(a[pivot] > a[i]){
                swap(a, i ,index);
                index++;
            }
        }
        swap(a,pivot,index-1);
        return index-1;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
