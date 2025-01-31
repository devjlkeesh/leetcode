package leetcode;

public class Easy618 {
    public int maximumProduct(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }

            if (num < n1) {
                n2 = n1;
                n1 = num;
            } else if (num < n2) {
                n2 = num;
            }
        }

        int p1 = m1 * m2 * m3;
        int p2 = n1 * n2 * m1;
        return Math.max(p1, p2);
    }
}
