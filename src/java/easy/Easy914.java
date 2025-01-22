package easy;

import java.util.HashMap;

public class Easy914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : deck) {
            map.merge(j, 1, Integer::sum);
        }
        int gcd = 0;
        for (int count : map.values()) {
            gcd = computeGCD(gcd, count);
            if (gcd == 1) {
                return false;
            }
        }
        return gcd >= 2;
    }

    private int computeGCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
