import java.util.Arrays;

public class binarySearch2DArray {
    public static void main(String[] args) {
        int arr[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int target = 15;

        System.out.println(Arrays.toString(striclysorted(arr,target)));
    }
    static int[] binarysIn2D(int [][] arr,int target){
        int[] an={-1,-1};
        int cl =arr[0].length-1;
        int rl = arr.length-1;
        int sr=0,sc=0,er=rl,ec=cl;
        while(sr<=er && ec>=0){
            if(arr[sr][ec]<target) sr++;
            else if(arr[sr][ec]>target) ec--;
            else return new int[] {sr,ec};

        }
        return an;
    }

    static int[] striclysorted(int [][] arr,int target){
        int[] an={-1,-1};
        int cl =arr[0].length-1;
        int rl = arr.length-1;
        int sr=0,sc=0,er=rl,ec=cl;
        while(sr<=er && sc<=ec){
            int mr = sr+(er-sr)/2,mc=sc+(ec-sc)/2;
            if(arr[mr][mc]<target){
                sr = mr;
                sc=mc;
            }
            else if(arr[sr][ec]>target){
                er=mr;
                ec = mc;
            }
            else return new int[] {sr,ec};

        }
        return an;
    }
}
