public class sum_of_digits_recursion {
    public static void main(String[] args) {
        System.out.println(smd(43321));
    }
    static int smd(int n){
        if(n<10){
            return n;
        }
        else{
            return n%10+smd(n/10);
        }
    }
}
