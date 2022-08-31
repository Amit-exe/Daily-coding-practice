public class orderAgnosticBinary_search {
    public static void main(String[] args) {
        int[] arr = {99,89,78,56,45,34,23,12,9,6,4,3,2,1};
        int target = 89;
        System.out.println(orderAgnosticBinarySearch(arr,target));

    }

    static int orderAgnosticBinarySearch(int[] arr, int target){
        int s = 0;
        int e = arr.length -1;
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
