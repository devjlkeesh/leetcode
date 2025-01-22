package easy;

public class Easy1137 {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            int temp = t0;
            t0 = t1;
            t1 = t2;
            t2 = temp + t0 + t1;
        }
        return t2;
    }

}
