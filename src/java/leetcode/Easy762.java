package leetcode;

public class Easy762 {
    public int countPrimeSetBits(int left, int right) {
        int[] primes = {
            0, -1, 2, 3, -4, 5, -6, 7, -8, -9, -10, 11, -12, 13, -14, -15, -16, 17, -18, 19,
        };
        int count = 0;
        while (left <= right) {
            int ones = Integer.bitCount(left);
            if (primes[ones] > 0) {
                count += 1;
            }
            left += 1;
        }
        return count;
    }
}
