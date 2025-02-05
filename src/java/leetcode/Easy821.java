package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy821 {
    public int[] shortestToChar(String s, char c) {
        int count = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexes.add(i);
            }
        }
        int j = 0;
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                ans[i] = Math.abs(i-indexes.get(j));
            }else{
                if (i < indexes.size()-1) {

                }
                ans[i] = Math.abs(i-indexes.get(j));
            }
        }

        return null;
    }
}
