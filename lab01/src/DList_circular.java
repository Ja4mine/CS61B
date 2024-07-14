public class DList_circular <T>{
    public class Node<T>{
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
    Node<T> sentinal;
    int size;
    public DList_circular(){
        sentinal = new Node<>(null, null, null);
        sentinal.next = sentinal;
        sentinal.previous = sentinal;
        size = 0;
    }
    public void insert(T value){
        Node<T> newNode = new Node<>(value, sentinal, sentinal.previous);
        sentinal.previous.next = newNode;
        sentinal.previous = newNode;
        size++;
    }
    public void removeFirst(){
        if(size == 0){
            return ;
        }else{
            Node<T> cur = sentinal.next;
            sentinal.next = sentinal.next.next;
            sentinal.next.previous = sentinal;
            cur.next = cur.previous = null;
            size--;
        }
    }

    public void removeLast(){
        if(size == 0){
            return;
        }else{
            Node<T> cur = sentinal.previous;
            sentinal.previous = sentinal.previous.previous;
            cur.previous.next = sentinal;
            cur.next = cur.previous = null;
            size--;
        }
    }

    public void display(){
        Node<T> cur = sentinal.next;
        while (cur != sentinal){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }


}
