import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class searching {
    public static void main(String[] args) {
        int arr[][] = {{2,3,1},{2,422,21},{-3,21}};
        int ar[] = search(arr,42);
        System.out.println(Arrays.toString(ar));
    }
    static int min(int[] arr){
        int m = MAX_VALUE;
        for(int num : arr){
            if(m>num){
                m=num;
            }
        }
        return  m;
    }
    static int[] search(int[][] arr,int target){
        for(int i =0;i<arr.length;++i){
            for(int j=0;j<arr[i].length;++j){
                if(target==arr[i][j])
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
