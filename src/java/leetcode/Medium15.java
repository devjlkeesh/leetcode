package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int positiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positiveIndex = i;
                break;
            }
        }
        if (positiveIndex == 0) {
            return List.of();
        }
        return null;

    }
}
