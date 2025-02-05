package leetcode;


public class Easy2815 {
    public int maxSum(int[] nums) {
        int[][] m = new int[10][2];
        int max = -1;
        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            if (num >= m[maxDigit][0]) {
                int temp = m[maxDigit][0];
                m[maxDigit][0] = num;
                m[maxDigit][1] = temp;
            } else if (num > m[maxDigit][1]) {
                m[maxDigit][1] = num;
            }
            if (m[maxDigit][0] > 0 && m[maxDigit][1] > 0) {
                max = Math.max(m[maxDigit][0] + m[maxDigit][1], max);
            }
        }
        return max;
    }

    private static int getMaxDigit(int n) {
        int maxDigit = 0;
        while (n > 0) {
            maxDigit = Math.max(maxDigit, n % 10);
            n /= 10;
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        Easy2815 demo = new Easy2815();
        System.out.println(demo.maxSum(new int[]{2536, 1613, 3366, 162}));
        System.out.println(demo.maxSum(new int[]{31, 25, 72, 79, 74}));
        System.out.println(demo.maxSum(new int[]{84,91,18,59,27,9,81,33,17,58}));
        System.out.println(demo.maxSum(new int[]{8,75,28,35,21,13,21}));
    }
}
