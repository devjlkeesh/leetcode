package leetcode;

import java.util.HashMap;

public class Easy169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer v = map.getOrDefault(num, 0);
            if (v >= n / 2) {
                return num;
            } else {
                map.put(num, v + 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Easy169 e = new Easy169();
        System.out.println(e.majorityElement(new int[]{3, 2, 3}));
    }
}
