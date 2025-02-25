package leetcode;

public class Easy2908 {
    public int minimumSum(int[] nums) {
        if (nums.length < 3) return -1;
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
        }

        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 1; j < n - 1; j++) {
            if (leftMin[j] < nums[j] && nums[j] > rightMin[j]) {
                minSum = Math.min(minSum, leftMin[j] + nums[j] + rightMin[j]);
            }
        }
        return (minSum == Integer.MAX_VALUE) ? -1 : minSum;
    }

    public static void main(String[] args) {
        Easy2908 demo = new Easy2908();
        System.out.println(demo.minimumSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5}));
        System.out.println(demo.minimumSum(new int[]{8, 6, 1, 5, 3}));
    }
}
