package com.ds.algo.linkedlist;/* 
@Author : Yogesh Deshmukh
*/

public class SingleLinkedList<T> {
    private Node head;
    private Node tail;

    private SingleLinkedList(){}

    public Node<T> createSingleLinkedlIst(T data){
        Node<T> newNode = new Node(data);
        head = new Node();
        head.next=newNode;
        tail = new Node();
        tail.next = newNode;
        return head;
    }

    public Node<T> insertNodeInLinkedList(){
        return null;
    }
}
class Node<T>{
    T data;
    Node next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
