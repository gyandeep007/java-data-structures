package io.github.datastructuresandalgorithm.datastructure.array;

public class DynamicArray {
    private int[] bucket;
    private int count;

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new NegativeArraySizeException("array size must not be negative");
        }

        this.bucket = new int[capacity];
        this.count = 0;
    }
    public int get(int index){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        return bucket[index];
    }
    public void set(int index,int val){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
         bucket[index] = val;
    }
    public void add(int val){
        growIfFull();
        bucket[count++] = val;
    }

    public void insert(int index, int value){

        if(!isValidInsertIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        growIfFull();
        for(int i=count;i>index;i--){
            bucket[i] = bucket[i-1];
        }
        bucket[index] = value;
        count++;
    }
    public void remove(int index){

        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        for(int i=index;i<count-1;i++){
            bucket[i] = bucket[i+1];
        }
        count--;
    }
   public int search(int val){
        for(int i=0;i<count;i++){
            if(bucket[i] == val)
                return i;

        }
        return -1;
   }
    public boolean contains(int value) {
        return search(value)!= -1;
    }
    private void growIfFull(){
        if(!isFull()){
            return;
        }
        int capacity=bucket.length==0?1:2* bucket.length;
        int[] temp = new int[capacity];
        for(int i=0;i<count;i++){
            temp[i] = bucket[i];
        }
        bucket = temp;

    }
    public int capacity(){
        return bucket.length;
    }
    public boolean isFull(){
        return count == bucket.length;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public int size() {
        return count;
    }
    public void clear() {
        count=0;
    }

    private boolean isValidIndex(int index){
        return index>=0 && index<count;
    }

    private boolean isValidInsertIndex(int index){
        return index>=0 && index<=count;
    }
}
