import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] ar = {3, 55, 4, 3, 2322, 1, 32, 5};
        reverse(ar);
        System.out.println(Arrays.toString(ar));

    }
    static void reverse(int [] ar){
        int s = 0;
        int e = ar.length -1;
        while(s<e){
            ar[s] = ar[s] + ar[e];
            ar[e] = ar[s] - ar[e];
            ar[s] = ar[s] - ar[e];
            s++;
            e--;
        }
    }
}