package leetcode;

public class Easy303 {
    private int[] nums;

    public Easy303(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return nums[right] - (left == 0 ? 0 : nums[left - 1]);
    }
}
