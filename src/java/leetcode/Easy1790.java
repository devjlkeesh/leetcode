package leetcode;

public class Easy1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int count = 0;
        char a1 = '0';
        char b1 = '0';
        char a2 = '0';
        char b2 = '0';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) {
                    a1 = s1.charAt(i);
                    a2 = s2.charAt(i);
                }
                b1 = s1.charAt(i);
                b2 = s2.charAt(i);
            }
            if (count > 2) return false;
        }
        return count == 2 && a1 == b2 && b1 == a2;
    }
}
