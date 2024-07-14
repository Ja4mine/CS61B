public class DList_double_sent<T> {
    private class Node<T>{
        T value;
        Node<T> previous;
        Node<T> next;

        public Node(T value, Node<T> previous, Node<T> next){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(){
            this(null, null, null);
        }
    }

    int size;
    Node<T> front_sentinal;
    Node<T> back_sentinal;


    public DList_double_sent(){
        size = 0;
        front_sentinal = new Node<>(null, null, null);
        back_sentinal = new Node<>(null, null, null);
        front_sentinal.next = back_sentinal;
        back_sentinal.previous = front_sentinal;
    }
    public void addFront(T value){
        size++;
        Node<T> newNode = new Node<T>(value, front_sentinal, front_sentinal.next);
        front_sentinal.next.previous = newNode;
        front_sentinal.next = newNode;

    }

    public void addLast(T value){
        size++;
        Node<T> newNode = new Node<T>(value, back_sentinal.previous,back_sentinal);
        back_sentinal.previous.next = newNode;
        back_sentinal.previous = newNode;
    }

    public void add(T value){
        if(size == 0){
            addFront(value);
        }else{
            addLast(value);
        }
    }

    public T getBack(){
        return back_sentinal.previous.value;
    }

    public void removeFront(){
        if(size == 0){
            return;
        }else{
            size--;
            Node<T> temp = front_sentinal.next;
            front_sentinal.next = front_sentinal.next.next;
            front_sentinal.next.previous = front_sentinal;
            temp.previous = temp.next = null;
         }
    }
    public void removeLast(){
        if(size == 0){
            return;
        }else if(size == 1){
            size--;
            removeFront();
        }else{
            size--;
            Node<T> temp = back_sentinal.previous;
            back_sentinal.previous = back_sentinal.previous.previous;
            back_sentinal.previous.next = back_sentinal;
            temp.next = temp.previous = null;
        }
    }




}
