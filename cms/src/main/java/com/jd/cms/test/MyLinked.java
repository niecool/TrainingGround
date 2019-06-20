package com.jd.cms.test;

/**
 * @author zhaochengye
 * @date 2019-06-19 15:26
 */
public class MyLinked<E> {

    private Node last;
    private Node first;
    private int size;

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    private static class Node<E>{
        E element;
        Node<E> pre;
        Node<E> next;

        Node(E element, Node pre, Node next){
            this.element = element;
            this.pre= pre;
            this.next = next;
        }
    }

    private void linkLast(E e){
        Node l = last;
        Node newNode = new Node<E>(e,last,null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }


    public static void main(String[] args) {
        MyLinked myLinked = new MyLinked<Integer>();
        myLinked.add(9);
        myLinked.add(5);
        myLinked.add(1);
        myLinked.add(7);
        myLinked.add(2);
        myLinked.add(3);
        myLinked.reverseLinked();
        System.out.println("success");
    }
    /**
     * 链表倒置
     */
    public void reverseLinked(){

//        if(first != null){
//            Node f = first;
//            Node l = last;
//            Node cur;
//
//
//
//
//        }
        if(last!=null){

        }
    }
    public Node reverse(Node curNode){
        if(curNode.next == null){
            return curNode;
        }
        Node prevNode = reverse(curNode.next);
        Node temp = curNode.next;

        temp.next = curNode;

        curNode.next = null;


        return prevNode;
    }


}
