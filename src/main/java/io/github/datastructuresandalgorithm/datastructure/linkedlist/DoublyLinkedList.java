package io.github.datastructuresandalgorithm.datastructure.linkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int count;
    public DoublyLinkedList(){
        head = null;
        tail = null;
        count =0;
    }

    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return head == null;
    }
    private static class Node{
        private int data;
        private Node prev;
        private Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
