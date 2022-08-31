public class evendigit {
    public static void main(String[] args) {
        int[] arr = {23,42331,4231,432,5654,9,54,9};
        int ct = 0;
        for(int num : arr){
            if(evd(num)) ct++;
        }
        System.out.println(ct);
    }

    static boolean evd(int num){
        int ct = 0;
        while(num!=0){
            ct++;
            num/=10;
        }
        return true;
    }
}
