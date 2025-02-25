package leetcode;

public class Easy3442 {
    public int maxDifference(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                if (map[i] % 2 == 0) {
                    even = Math.min(even, map[i]);
                }else {
                    odd = Math.max(odd, map[i]);
                }
            }
        }
        return odd - even;
    }
}
