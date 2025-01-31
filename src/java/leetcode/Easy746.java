package leetcode;

public class Easy746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        Easy746 demo = new Easy746();
        System.out.println(demo.minCostClimbingStairs(new int[]{10,15,20}));
    }
}
