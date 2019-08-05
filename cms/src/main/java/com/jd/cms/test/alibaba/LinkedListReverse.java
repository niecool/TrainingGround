package com.jd.cms.test.alibaba;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 链表逆转
 *
 * @author zhaochengye
 * @date 2019/8/1
 */
public class LinkedListReverse {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 1.最简单的思想是组建新的链表
     * @param head
     * @return
     */
//    public static ListNode reverseList(ListNode head) {
//        ListNode first = null;
//        if(head!=null){
//            first = new ListNode(head.val);
//            while (head.next!=null){
//                ListNode temp = new ListNode(head.next.val);
//                head = head.next;
//                temp.next = first;
//                first = temp;
//            }
//
//        }
//        return first;
//    }


    /**
     * 直接使用原来节点，逆转
     * @param head
     * @return
     */
//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        if(head != null) {
//            head = head.next;
//            cur.next = null;
//            while (head != null) {
//                pre = head;
//                head = head.next;
//                pre.next = cur;
//                cur = pre;
//            }
//        }
//        return cur;
//    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println("haha");
        reverseList(head);
        System.out.println("yy");
    }

}
