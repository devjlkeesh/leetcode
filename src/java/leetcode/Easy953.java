package leetcode;

public class Easy953 {
        public boolean isAlienSorted(String[] words, String order) {
            for (int i = 0; i < words.length - 1; i++) {
                if (!sorted(words[i], words[i + 1],order)) {
                    return false;
                }
            }
            return true;
        }

        boolean sorted(String w1, String w2,String order) {
            int l1 = w1.length();
            int l2 = w2.length();
            for (int i = 0; i < Math.min(l1, l2); i++) {
                int c1 = order.indexOf(w1.charAt(i));
                int c2 = order.indexOf(w2.charAt(i));
                if (c1 != c2) {
                    return c1 < c2;
                }
            }
            return l1 <= l2;
        }
}
