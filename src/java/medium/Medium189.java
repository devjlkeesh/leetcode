package medium;

import java.util.Arrays;

public class Medium189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] d = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            d[(j + k) % nums.length] = nums[j];
        }
        System.arraycopy(d, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Medium189 m = new Medium189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        m.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
