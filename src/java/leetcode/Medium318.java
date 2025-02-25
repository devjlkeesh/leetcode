package leetcode;

public class Medium318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            String wordi = words[i];
            int[] map = new int[26];
            for (char c : wordi.toCharArray()) {
                if (map[c - 'a'] == 0) map[c - 'a'] = 1;
            }

            for (int j = i + 1; j < n; j++) {
                String wordj = words[j];
                boolean flag = true;
                for (char c : wordi.toCharArray()) {
                    if (map[c - 'a'] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) max = Math.max(max, wordi.length() * wordj.length());
            }
        }
        return max;
    }

    public int maxProduct2(String[] words) {
        int max = 0;
        int n = words.length;
        int[] bitmasks = new int[n];
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
               bitmasks[i] |= (1 << (c - 'a'));
            }
            lengths[i] = word.length();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
               if ((bitmasks[i] & bitmasks[j]) == 0){
                   max = Math.max(lengths[i],lengths[j]);
               }
            }
        }
        return max;
    }
}
