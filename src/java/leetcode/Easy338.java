package leetcode;

import java.util.HashMap;

public class Easy338 {
    HashMap<Integer, Integer> map = new HashMap<>();
    private static int[] bits = new int[256];
    static {
        for (int i = 0; i < 256; i++) {
            bits[i] = (i & 1) + bits[i >> 1];
        }
    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            ans[i] = bits[i &0xFF] + bits[(i >> 8) & 0xFF] + bits[(i >> 16) & 0xFF] + bits[(i >> 24) & 0xFF];
        }
        return ans;
    }

    public int count(int n) {
        if (n == 0) return 0;
        if (map.containsKey(n))
            return map.get(n);
        return (n & 1) + count(n >> 1);
    }

    public static void main(String[] args) {
        Easy338 demo = new Easy338();
        System.out.println(demo.count(2));
        System.out.println(demo.count(3));
        System.out.println(demo.count(4));
        System.out.println(demo.count(5));
        System.out.println(demo.count(6));
        System.out.println(demo.count(3));
    }
}
