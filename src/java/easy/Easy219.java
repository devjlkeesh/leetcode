package easy;

import java.util.HashMap;
import java.util.Map;

public class Easy219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null && Math.abs(value - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
