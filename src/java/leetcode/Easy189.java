package leetcode;

import java.util.Arrays;

public class Easy189 {
    public void rotate(int[] nums, int k) {
        if (nums.length < k){
            return;
        }
        int[] arr = new int[k];
        int i = k-1;
        int n = nums.length - 1;
        while (i  >= 0 && n >= 0) {
            arr[i--] = nums[n--];
        }
        int l = nums.length - 1;
        int r = l - k;
        while (r >= 0) {
            nums[l--] = nums[r--];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }

    public static void main(String[] args) {
        Easy189 e = new Easy189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        e.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {-1, -100, 3, 99};
        e.rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {-1};
        e.rotate(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }
}
