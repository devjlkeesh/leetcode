package leetcode;

public class Easy1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        int[] count2 = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count2[c - 'a']++;
            }
            int a = word.length();
            for (int i = 0; i < 26; i++) {
                if (count[i] < count2[i]) {
                    a = 0;
                    count2 = new int[26];
                    break;
                }
                count2[i] = 0;
            }
            res += a;
        }
        return res;
    }
}
