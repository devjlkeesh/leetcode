package leetcode;

public class Easy3345 {
    public int smallestNumber(int n, int t) {
        while (n < Integer.MAX_VALUE) {
            int a = n;
            int product = 1;
            while (a > 0) {
                int digit = a % 10;
                if (digit == 0) {
                    product = 0;
                    break;
                }
                product *= digit;
                a /= 10;
            }
            if (product % t == 0) {
                return n;
            } else {
                n++;
            }
        }
        return n;
    }
}
