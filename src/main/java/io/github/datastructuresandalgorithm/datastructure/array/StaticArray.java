package io.github.datastructuresandalgorithm.datastructure.array;

public class StaticArray {
    private int[] bucket;
    private int count;

    public StaticArray(int capacity) {
        if(capacity<0){
            throw new NegativeArraySizeException("array size must not be negative");
        }
        this.bucket = new int[capacity];
        this.count= 0;
    }

    public StaticArray(int[] bucket) {
        if(bucket == null){
            throw new NullPointerException("array is not correct ");
        }
        int[] temp = new int[bucket.length];
        for(int i=0;i<bucket.length;i++){
            temp[i] = bucket[i];
        }
        this.bucket = temp;
        this.count= temp.length;
    }

    public int get(int index){
        if(!isValidIndex(index))
            throw new IndexOutOfBoundsException("index is not valid");
        return bucket[index];
    }

    public void set(int index,int value){
        if(!isValidIndex(index))
            throw new IndexOutOfBoundsException("index is not valid");
         bucket[index]=value;
    }
    public void insert(int index,int val){
        if(!isValidInsertIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        if(isFull()){
            throw new IllegalStateException("array is full");
        }
        for(int i=count;i>index;i--){
            bucket[i] = bucket[i-1];
        }
        bucket[index] = val;
        count++;
    }

    public void add(int val){
        if(isFull() ){
            throw new IllegalStateException("array is full");
        }

        bucket[count++] = val;
    }

    public void remove(int index){
        if(isEmpty()){
            throw new IllegalStateException("array is empty");
        }
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("index is not valid");
        }
        for(int i = index;i<count-1;i++){
            bucket[i] = bucket[i+1];
        }
        bucket[--count]=0;
    }

    public int search(int val){
        for(int i=0;i<count;i++){
            if(bucket[i] == val)
                return i;
        }
        return -1;
    }
    public boolean contains(int val){
        return search(val) != -1;
    }

    public void clear() {
        count=0;
    }
    public int size() {
        return count;
    }
    public int capacity() {
        return bucket.length;
    }
   private boolean isValidInsertIndex(int index){
        return index>=0 && index<= count;
   }
    public boolean isFull(){
        return count == bucket.length;
    }
    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isValidIndex(int index){
        return index>=0 && index<count;
    }
}
