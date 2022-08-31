public class recursion {
    public static void main(String[] args) {
        int tp=4,n=1162261468;
        System.out.println(sln(n,tp));
    }
    static boolean sln(int n, long tp) {
        if (tp > n) {
            return false;
        } else if (tp == n) {
            return true;
        } else {
            System.out.println(tp);
            return sln(n, tp * 4);
        }
    }
}
