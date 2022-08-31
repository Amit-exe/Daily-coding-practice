public class rotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(arr,target));
    }
    static int search(int[] nums, int target) {

        if(nums.length==1){
            if(nums[0]==target) return 0;
            else return -1;
        }

        int pivot = findPivot(nums);
        if(pivot==-1){
            return orderAgnosticBinarySearch(nums,target,0,nums.length-1);
        }
        else{
            int fh = orderAgnosticBinarySearch(nums,target,0,pivot);
            if(fh!=-1) return fh;
            else{
                return orderAgnosticBinarySearch(nums,target,pivot+1,nums.length-1);

            }
        }


    }

    static int findPivot(int[] arr){

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

    static int orderAgnosticBinarySearch(int[] arr, int target,int s,int e){
        boolean asc = true;
        if(arr[e]<arr[s]) asc=false;
        int an =-1;

        while(s<=e){
            int m= s+(e-s)/2;
            if(asc) {
                if (arr[m] > target) e = m - 1;
                else if (arr[m] < target) s = m + 1;
                else return m;
            }
            else{
                if (arr[m] > target) s= m - 1;
                else if (arr[m] < target) e = m + 1;
                else return m;
            }

        }

        return an;
    }
}
