package easy;

import java.util.ArrayList;
import java.util.List;

public class Easy228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        String b;
        String e;
        long bb = Long.MIN_VALUE;
        int ee;
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == k) {
                if (bb != Long.MIN_VALUE){
                    ee = nums[i];
                }else{
                    bb = nums[i];
                    ee = nums[i];
                }
            }
        }
        return new ArrayList<>();
    }
}
