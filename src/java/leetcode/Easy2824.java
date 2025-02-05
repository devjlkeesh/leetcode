package leetcode;

import java.util.List;

public class Easy2824 {
    public int countPairs(List<Integer> nums, int target) {
        int c = 0;
        int[] arr = new int[nums.size()];
        for (Integer num : nums) {
            arr[c++] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] < target) {
                    c++;
                }
            }
        }
        return c - arr.length;
    }
}
