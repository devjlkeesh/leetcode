package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Easy3289 {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int[] result = new int[2];
        for (int num : nums) {
            if (set.contains(num)) {
                result[i++] = num;
                if (i == 2) {
                    break;
                }
            } else {
                set.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Easy3289 solution = new Easy3289();
        System.out.println(Arrays.toString(solution.getSneakyNumbers(new int[]{0, 1, 1, 0})));
    }
}
