public class binarySearch_recursion {
    public static void main(String[] args) {
        int[] arr = {-99,-55,-3,1,4,5,32,121,122,150,170,1203,9999};
        int target = 9999;
        System.out.println(binarysearch(arr,target,0,arr.length-1));
    }

    static int binarysearch(int[] arr, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s+(e-s)/2;
        if(arr[m]==target) return  m;
        if(arr[m]<target){
            return binarysearch(arr,target,m+1,e);
        }
        else return binarysearch(arr,target,s,m-1);
    }
}
