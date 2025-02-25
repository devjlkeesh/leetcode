package leetcode;

public class Medium316 {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
