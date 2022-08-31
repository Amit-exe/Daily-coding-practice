public class binarys {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(binarysearch(arr,target));
    }

    static int binarysearch(int[] arr, int target){

        int start = 0;
        int end = arr.length -1;
        int an=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]<=arr[start]) end = mid-1;
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
