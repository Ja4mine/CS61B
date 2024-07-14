import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListSet<T>{
    private T[] items;
    private int size;

    public ListSet(){
        this.items = (T[]) new Object[10];
        this.size = 0;
    }

    public Boolean Contains(T element){
        for(int i = 0; i < size; i++){
            if(items[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void Add(T element){
        if(size == items.length){
            System.out.println("The set is full!");
        }else{
            for(int i = 0; i < size; i++){
                if(items[i] == null){
                    if(element == null){
                        System.out.println("\"null\" element is already in the set!");
                        return;
                    }
                    items[i] = element;
                    return;
                }
            }
        }
    }

    public void Remove(T element){
        if(size == 0){
            System.out.println("The set is empty!");
        }else if(!this.Contains(element)){
            System.out.println("The element is not in the set!");
        }else{
            for(int i = 0; i < size; i++){
                if(items[i].equals(element)){
                    items[i] = null;
                }
            }
        }
    }

//    public Iterator<T> Iterator{
//       return new ArraySetIterator();
//    }
//TODO: find why this code throw error
    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }

        public boolean hasNext(){
            return wizPos < size;
        }

        public T next(){
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }


    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Iterator it2 = set.iterator();
        while(it2.next() != null){
            System.out.println(it2.next());
        }

    }
}
