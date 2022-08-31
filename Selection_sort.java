import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int arr[] = {-2,345,98,65,5,4,3,2,1,-6,7,-98,32};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr){


        for(int i=0;i<arr.length;++i){
            int max=0;
            for(int j=0;j<arr.length-i;++j){
                if(arr[max]<arr[j]) max = j;
            }
            int t=arr[max];
            arr[max] = arr[arr.length-i-1];
            arr[arr.length-i-1] = t;
        }
    }
}
