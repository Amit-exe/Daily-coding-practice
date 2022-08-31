public class findMinInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        int n = findPeak(nums);
        if(n==nums.length-1 || nums[0]<=nums[nums.length-1]) System.out.println(nums[0]);
        System.out.println(nums[n+1]);
    }
    static int findPeak(int[] nums){
        int s =0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(m<nums.length && nums[m]>nums[m+1]) return m;
            if(m>0 && nums[m-1]>nums[m]) return m;
            if(nums[m]<nums[s]) m =s;
            else s=m;
        }
        return -1;
    }
}
