import net.sf.saxon.expr.Component;

public class AList{
    public static final int MAX_SIZE = 10;
    private int size;
    private int capacity;
    private double usage_ratio = size / capacity;
    private int[] arr;
    public AList() {
        this.size = 0;
        this.capacity = MAX_SIZE;
        this.arr = new int[MAX_SIZE];

    }
    //还可以定义一个size checker，如果使用率太低，就可以将数组的长度减半
    public void usage_ratio_checker(){
        if(usage_ratio < 0.25){
            this.capacity = this.capacity / 2;
            int[] temp = new int[this.capacity];
            System.arraycopy(arr, 0, temp, 0, this.size);
            this.arr = temp;
        }
    }



    private void resize_add(){ // 这种方式非常非常慢 在一般情况下，扩容使用乘法
        int[] temp = new int [MAX_SIZE + 1];
        this.capacity = MAX_SIZE + 1;
        System.arraycopy(this.arr, 0, temp, 0, arr.length);
        this.arr = temp;
    }
    private void resize_mult(){
        int[] temp = new int[2 * MAX_SIZE];
        this.capacity = 2 * MAX_SIZE;
        System.arraycopy(this.arr, 0, temp, 0, arr.length);
        this.arr = temp;
    }

    public void addLast(int element){
        if(size == MAX_SIZE) resize_mult();
        this.arr[size++] = element;
    }

    public int getLast(){
        return this.arr[size - 1];
    }

    public void removeLast(){
        this.arr[--size] = 0; // 清除引用，释放内存 在泛型数组中，这里可以设置为null
    }

    public int getIndex(int index){
        return this.arr[index];
    }
    public void print(){
        for(int i = 0; i < size; i++) System.out.print(this.arr[i] + "  ");
    }

    public int getSize(){
        return this.size;
    }
    public static void main(String[] args) {
        AList list = new AList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.addLast(11);
        System.out.println("The size of the list is: " + list.getSize());
        list.print();

    }
}
