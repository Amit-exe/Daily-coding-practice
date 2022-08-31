import java.util.ArrayList;
import java.util.Arrays;

public class cyclicSort {
    public static void main(String[] args) {
        ArrayList<Integer> an;
        int arr[] = {4,3,2,7,8,2,3,1};
                cycleSort(arr);
                System.out.println(Arrays.toString(arr));
    }
    static  void cycleSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int cid = arr[i]-1;
            if(arr[i]!=arr[cid]){
                swap(arr,cid,i);

            }else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int id1,int id2){
        int temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }
}
