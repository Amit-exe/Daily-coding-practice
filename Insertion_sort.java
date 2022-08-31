import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        int arr[] = {-2,345,98,65,5,4,3,2,1,-6,7,-98,32};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void InsertionSort(int[] arr){
        for(int i = 0; i<arr.length-1;i++) {
            for (int j = i+1; j > 0 ; j--) {
                    if(arr[j]<arr[j-1]){
                        int t = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] =t;
                    }
                    else break;

            }
        }
    }
}
