package leetcode;

public class Easy389 {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map[t.charAt(i) - 97]++;
            map[s.charAt(i) - 97]--;
        }
        map[t.charAt(n) - 97]++;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                return (char) (i + 97);
            }
        }
        return '0';
    }
}
