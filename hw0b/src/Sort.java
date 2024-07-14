public class Sort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] merge(int[] arr1, int m, int[] arr2, int n) {
        int ptr = 0;
        if(m == 0 || n == 0){
            if(m == 0){
                sort(arr2);
                return arr2;
            }else{
                sort(arr1);
                return arr1;
            }
        }

        for(int i = 0; i < m; i++){
            if(arr1[i] > arr2[ptr]){
                int temp = arr1[i];
                arr1[i] = arr2[ptr];
                arr2[ptr] = temp;
                continue;
            }
            
        }


        return null;
    }

    public static void sort(int[] arr) {
        for(int i = 0; i<arr.length; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
