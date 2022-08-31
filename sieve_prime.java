import java.util.ArrayList;
import java.util.Arrays;

public class sieve_prime {
    public static void main(String[] args) {
        int n=50;
        int[] ans =sieve(n);
        for(int i=0;i<n;i++){
            if(ans[i]==1) System.out.println(i);
        }
    }
    static int[] sieve(int n){
        int[] an = new int[n];
        Arrays.fill(an,1);
        for(int i=2;i<n;i++){
            if(an[i]==1){
                for(int j=i+i;j<n;j+=i){
                    an[j]=0;
                }
            }
            else{
                continue;
            }
        }
        return an;
    }
}
