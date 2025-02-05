package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy2899 {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int num : nums) {
            if (num != -1) {
                seen.add(num);
                k = 0;
            } else {
                if (seen.size() > k) {
                    ans.add(seen.get(seen.size() - k - 1));
                } else {
                    ans.add(-1);
                }
                k++;
            }
        }
        return ans;
    }

    public List<Integer> lastVisitedIntegers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        int k = 0;
        for (int num : nums) {
            if (num != -1) {
                seen.addLast(num);
                k = 0;
            } else {
                ans.add(seen.size() > k ? seen.get(seen.size() - k - 1) : -1);
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Easy2899 demo = new Easy2899();
        System.out.println(demo.lastVisitedIntegers(new int[]{1, 2, -1, -1, -1}));
        System.out.println(demo.lastVisitedIntegers(new int[]{1, -1, 2, -1, -1}));
    }
}
