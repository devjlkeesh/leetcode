package leetcode;

import java.util.List;

public class Easy2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum+=nums.get(i);
            }
        }
        return sum;
    }
}
