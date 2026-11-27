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
    public void addFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        count++;
    }
    public int getFirst(){
        if(isEmpty()){
            throw new IllegalStateException("list is empty");
        }
        return head.data;
    }
    public void addLast(int val){
        Node node=new Node(val);
        if(isEmpty())
            head=node;
        else {
            Node current = head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=node;
        }
        count++;

    }
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
    public int get(int index){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        int i=0;
        Node current = head;
        while (i<index){
            current=current.next;
            i++;
        }
        return current.data;
    }
    public void insert(int index,int val){
        if(!isValidInsertIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        Node node =new Node(val);
        if(isEmpty() || index==0) {
           node.next = head;
            head = node;
        }else{
            int i=0;
            Node current = head;
            while (i<index-1){
                current = current.next;
                i++;
            }
            node.next = current.next;
            current.next = node;
        }
       count++;
    }
    public int removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("list is empty");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        count--;
        return node.data;
    }
    public int removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("list is empty");
        }
        Node node;
        if(head.next == null){
            node = head;
            head =null;
        }else{
            Node current = head;
            Node prev=null;
            while (current.next != null){
                prev = current;
                current=current.next;
            }
            node = current;
            prev.next = null;
        }
        count--;
        return node.data;
    }
    public int remove(int index){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("not a valid index");
        }
        Node node;
        if(index ==0){
            node = head;
            head = head.next;
        }else {
            int i=0;
            Node current = head;
            while (i<index-1){
                current = current.next;
                i++;
            }
            node = current.next;
            current.next = node.next;
            node.next=null;
        }
        count--;
        return node.data;
    }
    public int search(int val){
        if(isEmpty())
            return -1;
        int i=0;
        Node current = head;
        while (current.data != val && current.next!=null){
            current=current.next ;
            i++;
        }
        return current.data==val?i:-1;

    }
    public boolean contains(int val){
        return search(val) != -1;
    }
    public void clear(){
        head = null;
        count=0;
    }
    private boolean isValidIndex(int index){
        return index>=0 && index<count;
    }
    private boolean isValidInsertIndex(int index){
        return index>=0 && index<=count;
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
