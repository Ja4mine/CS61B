import org.apache.commons.lang3.builder.Diff;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private int capacity;
    private int size;
    private int nextLast;
    private int nextFirst;
    private T[] items;

    public boolean isFull(){return size == capacity;}

    public ArrayDeque61B() {
        this.size = 0;
        this.capacity = 10;
        this.nextLast = this.capacity/2 + 1;
        this.nextFirst = nextLast - 1;
        this.items = (T[]) new Object[this.capacity];
    }

    @Override
    public void addFirst(T x) {
        if(isFull()) {
            T[] newItems = (T[]) new Object[this.capacity * 2];
            //TODO:补充复制填充逻辑
            for(int i = 0; i < this.size; i++) newItems[i] = this.get(i);
            this.items = newItems;
            this.nextLast = this.size;
            this.capacity *= 2;
            this.nextFirst = this.capacity - 1;
        }
            this.items[this.nextFirst] = x;
            //this.nextFirst = this.nextFirst - 1 < 0 ? this.nextFirst - 1 + this.capacity : this.nextFirst - 1;
            this.nextFirst = (this.nextFirst - 1 + this.capacity) % this.capacity;
            size++;
    }
    
    @Override
    public void addLast(T x) {
        if(isFull()) {
            //TODO:补充复制填充逻辑
            T[] newItems = (T[]) new Object[this.capacity * 2];
            for(int i = 0; i < this.size; i++) newItems[i] = this.get(i);
            this.items = newItems;
            this.nextLast = this.size;
            this.capacity *= 2;
            this.nextFirst = this.capacity - 1;
        }
            this.items[this.nextLast] = x;
            //this.nextLast = this.nextLast + 1 > this.capacity? this.nextLast + 1 - this.capacity : this.nextFirst + 1;
            this.nextLast = (this.nextLast + 1 + this.capacity) % this.capacity;
            size++;

    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<T>();
        for(int i = 0; i < this.size; i++) list.add(this.get(i));
        return list;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int getCapacity(){return this.capacity;}


    public void size_adjustment(){
        double quotient = this.size() / (double) this.capacity;
        //TODO:添加尺寸缩小操作
        if(quotient >= 0.25) return;
        else{
            int newCapacity = this.size() < 15 ? 15 : this.capacity / 2;
            T[] tempArray = (T[]) new Object[newCapacity];
            for(int i = 0; i < this.size; i++) tempArray[i] = this.get(i);
            this.nextLast = this.size;
            this.nextFirst = newCapacity - 1;
            this.capacity = newCapacity;
            this.items = tempArray;
        }
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        size_adjustment();
        T result = get(0);
        this.nextFirst = (this.nextFirst + 1) % this.capacity;
        this.size--;
        return result;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        size_adjustment();
        T result = get(this.nextLast - 1);
        this.nextLast = (this.nextLast - 1) % this.capacity;
        size--;
        return result;
    }

    @Override
    public T get(int index) {
        return items[(this.nextFirst + 1 + index) % this.capacity];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public void print(){
        for(int i = 0; i < this.size; i++) System.out.print(this.get(i) + " ");
    }

    public static void main(String[] args){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for(int i = 0; i < 10000; i++){
            deque.addLast(i);
        }
        System.out.println(deque.size() + " <- Size of the deque ");
        System.out.println(deque.getCapacity() + " <- capacity of the deque");

        for(int i = 0; i < 9999; i++){
            deque.removeLast();
        }
        System.out.println(deque.size() + " <- Size of the deque ");
        System.out.println(deque.getCapacity() + " <- capacity of the deque");
        //deque.print();
    }
}
