package leetcode;

public class Easy896 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        if (nums[0] > nums[nums.length - 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
