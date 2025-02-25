package leetcode;

public class Easy859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] sChars = s.toCharArray();
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                int c = sChars[i] - 'a';
                map[c]++;
                if (map[c] > 1) {
                    return true;
                }
            }
            return false;
        }
        int i = -1;
        int j = -1;
        char[] goalChars = goal.toCharArray();
        for (int k = 0; k < s.length(); k++) {
            if (sChars[k] != goalChars[k]) {
                if (i == -1) {
                    i = k;
                } else if (j == -1) {
                    j = k;
                } else {
                    return false;
                }
            }
        }
        return j != -1 && sChars[i] == goalChars[j] && sChars[j] == sChars[i];
    }

    public static void main(String[] args) {
        Easy859 demo = new Easy859();
        System.out.println(demo.buddyStrings("aa", "aa"));
        System.out.println(demo.buddyStrings("ab", "ab"));
        System.out.println(demo.buddyStrings("ba", "ab"));
    }
}
