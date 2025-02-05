package leetcode;

import java.util.Map;

public class Medium50 {
    public double myPow(double x, int n) {
        long e = n;
        if (e < 0) {
            x = 1 / x;
            e = -e;
        }
        double result = 1.0;
        while (e > 0) {
            if (e % 2 == 1) {
                result *= x;
            }
            x *= x;
            e /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Medium50 m = new Medium50();
        System.out.println(m.myPow(2.0, 10));
        System.out.println(m.myPow(2.0, -2));
    }
}
