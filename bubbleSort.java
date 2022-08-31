import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int [] arr){

        for(int i = 0; i<arr.length;i++){
            boolean anyswap = false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    arr[j] = arr[j-1] + arr[j];
                    arr[j-1] = arr[j] - arr[j-1];
                    arr[j] = arr[j] - arr[j-1];
                    anyswap = true;

                }

            }
            if(!anyswap) break;
        }
    }
}
