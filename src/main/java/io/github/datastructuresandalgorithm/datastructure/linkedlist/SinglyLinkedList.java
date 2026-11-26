package io.github.datastructuresandalgorithm.datastructure.linkedlist;

public class SinglyLinkedList {
    private Node head;
    private int count;


    public SinglyLinkedList(){
        head = null;
        count = 0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty() {
        return head == null;
    }
    private static class Node {

        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
