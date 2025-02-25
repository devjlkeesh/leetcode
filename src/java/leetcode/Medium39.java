package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> map = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int candidate : candidates) {
            if (candidate < target) {
                map.add(candidate);
            } else if (candidate == target) {
                res.add(List.of(candidate));
            }
        }
        map.sort(Integer::compareTo);
        return res;
    }
}
