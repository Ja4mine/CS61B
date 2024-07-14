import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B <T> implements Deque61B<T> {
    private class Node{ // 内部节点不用再定义泛型类了，可以直接使用外部Linklist的泛型类型，内部再重新定义会导致冲突，内部会覆盖外部
        T data;
        Node next;
        Node previous;
        private Node(T data, Node next, Node previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque61B() {
        this.sentinel = new Node(null,null,null);
        this.size = 0;
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x,sentinel.next,sentinel);
        sentinel.next.previous = newNode;
        sentinel.next = newNode;
        this.size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x,sentinel,sentinel.previous);
        sentinel.previous.next = newNode;
        sentinel.previous = newNode;
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<>();
        Node cur = sentinel.next;
        while(cur != sentinel){
            result.add(cur.data);
            cur = cur.next;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        Node cur = sentinel.next;
        sentinel.next = cur.next;
        sentinel.next.previous = sentinel;
        T result = cur.data;
        cur.next = cur.previous = null;
        size--;
        return result;
    }

    @Override
    public T removeLast() {
        Node cur = sentinel.previous;
        sentinel.previous = cur.previous;
        cur.previous.next = sentinel;
        T result = cur.data;
        cur.next = cur.previous = null;
        return result;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size) return null;
        int count = 0;
        Node cur = sentinel.next;
        while(count < index){
            cur = cur.next;
            count++;
        }
        return cur.data;
    }

    @Override
    public T getRecursive(int index) {
        if(index < 0 || index >= this.size) return null;
        return getRecursiveHelper(index, 0 , sentinel.next);
    }

    public T getRecursiveHelper(int index, int count, Node cur) {
        if(count == index) return cur.data;
        return getRecursiveHelper(index, count + 1, cur.next);
    }
}
