package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Easy1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int num : arr) {
            count[num + 1000]++;
        }
        int uniqueCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : count) {
            if (i > 0) {
                uniqueCount++;
                set.add(i);
            }
        }
        return set.size() == uniqueCount;
    }
}
