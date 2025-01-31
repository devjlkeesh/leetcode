package leetcode;

public class Easy643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return ((double) maxSum) / k;
    }

    public static void main(String[] args) {
        Easy643 easy643 = new Easy643();
        System.out.println(easy643.findMaxAverage(new int[]{7, 4, 5, 8, 8, 3, 9, 8, 7, 6}, 7));
        System.out.println(easy643.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(easy643.findMaxAverage(new int[]{5}, 1));
    }
}
