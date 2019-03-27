package com.jd.cms.test.impl;

import com.jd.cms.test.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhaochengye
 * @date 2018/12/13 09:57
 */
public class TestImpl implements Test {
    private int a = 0;

    // https://www.cnblogs.com/flotang/p/9216098.html
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        System.out.println(list);
//
////        for (int i = 0; i < 5; i++) {
////            list.remove(0);
////            System.out.println(list);
////        }
//
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            iterator.next();
//            iterator.remove();
//            System.out.println(list);
//        }
//        System.out.println(list);
//
//
//        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
//        int[] nums = {3,2,4};
//        int target = 6;
//        target = new TestImpl().reverseBits(-3);

//        new TestImpl().stringContains("zcz", "sadugiusaZczcydbcudzczczksybdsibucnsdbcsduy");
//        new TestImpl().toLowerCase("Hello");
//        int[] a = {-4, -1, 0, 3, 10};
//        new TestImpl().sortedSquares(a);
        int[][] A = new int[2][3];
        new TestImpl().flipAndInvertImage(A);

    }


    public static int[] twoSumPro(int[] nums, int target) {
        Integer sum;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (target == sum && map.get(i) == null) {
                    map.put(j, i);
                    List temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);

                }
            }
        }
        return new int[2];
    }

    public int[] twoSum(int[] nums, int target) {
        Integer sum;
        int len = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int reverse(int x) {
        Double result = 0.0;
        Boolean flag = true;
        ArrayList list = new ArrayList<Integer>();
        if (x < 0) {
            flag = false;
            x = 0 - x;
        }
        while (x > 0) {
            list.add(x % 10);
            x = x / 10;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int temp = (Integer) it.next();
            if (temp != 0) {
                result = result + temp * Math.pow(10, list.size() - 1);
            }
            it.remove();
        }
        if (!flag) {
            result = 0 - result;
        }
        System.out.println(result.intValue());
        return result.intValue();
    }


    public int reverseBits(int n) {
//        System.out.println(Integer.toBinaryString(i));
//        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
//        System.out.println(Integer.toBinaryString(i));
//        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
//        System.out.println(Integer.toBinaryString(i));
//        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
//        System.out.println(Integer.toBinaryString(i));
//        i = (i << 24) | ((i & 0xff00) << 8) |
//                ((i >>> 8) & 0xff00) | (i >>> 24);
//        System.out.println(Integer.toBinaryString(i));

        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;//基偶交换
        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;//每四位，高低两位交换
        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;//每8为，高低4位交换
        n = (n & 0x00ff00ff) << 8 | (n >>> 8) & 0x00ff00ff;//每16位，高低8位交换
        n = (n & 0x0000ffff) << 16 | (n >>> 16) & 0x0000ffff;//每32位，高低16位交换
        System.out.println(n);
        return n;
    }

    /**
     * 字符串 contains
     */
    /**
     *
     */
    public int stringContains(String J, String S) {
        char[] arr = J.toCharArray();
        int num = 0;
        for (char c : arr) {
            if (S.indexOf(c) != -1) {
                num++;
            }

        }
        return num;
    }

    public int numJewelsInStones(String J, String S) {
        int num = 0;
        char[] charArray = J.toCharArray();
        for (char c : charArray) {
            while (S.contains(c + "")) {
                S = S.substring(S.indexOf(J) + J.length());
                num++;
            }
        }

        return num;
    }

    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] + 32);
            }
        }
        return String.valueOf(arr);
    }

    //插入排序最高效 lamda表达式就一行target.stream.map(_*_).sorted
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int target;
        for (int i = 0; i < len; i++) {
            target = A[i] * A[i];
            int j = i;
            while (j > 0 && result[j - 1] > target) {
                result[j] = result[j - 1];
                j--;
            }
            result[j] = target;

        }
        return result;
    }

    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }
        //调换顺序
        char[] str = S.toCharArray();
        for (int i = 0; i < n; i++) {
            if (str[i] == 'I') {

            } else {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

//    public void deleteNode(ListNode node) {
//        ListNode node =
//    }

    public int[][] flipAndInvertImage(int[][] A) {
        int one = A.length;
        int two = A[0].length;
        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][two-1-i];
                A[i][two-1-i] = temp;
            }
        }
        return A;
    }
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            if(A==null) return null;
            for(int i=0;i<A.length;i++){
                for(int j=0,k=A[i].length-1;j<=k;j++,k--)
                {
                    int tmp = A[i][k]; A[i][k] = A[i][j]^1; A[i][j] = tmp^1;
                }
            }
            return A; } }




}
