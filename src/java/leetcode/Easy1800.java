package leetcode;

public class Easy1800 {
    public int maxAscendingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                sum += nums[i];
            }else{
                max = Math.max(max, sum);
                sum  = nums[i];
            }
        }
        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[] args) {
        Easy1800 demo = new Easy1800();
        System.out.println(demo.maxAscendingSum(new int[]{ 10,20,30,5,10,50}));
        System.out.println(demo.maxAscendingSum(new int[]{ 10,20,30,40,50}));
        System.out.println(demo.maxAscendingSum(new int[]{ 12,17,15,13,10,11,12}));
    }
}
