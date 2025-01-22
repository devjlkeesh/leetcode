package medium;

import java.util.HashMap;
import java.util.Map;

public class Middle287 {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Middle287 e = new Middle287();
        System.out.println("res " + e.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
