package leetcode;

public class Easy748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] m = new int[26];
        for (int c : licensePlate.toCharArray()) {
            if (c >= 65) {
                m[c - (c < 'a' ? 65 : 97)]++;
            }
        }
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (compare(m, words[i]) && (index == -1 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        return words[index];
    }

    private boolean compare(int[] m, String word) {
        int[] tm = new int[26];
        for (int j = 0; j < word.length(); j++) {
            tm[word.charAt(j) - 97]++;
        }
        for (int j = 0; j < 26; j++) {
            if (tm[j] < m[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy748 demo = new Easy748();
        System.out.println(demo.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }
}
