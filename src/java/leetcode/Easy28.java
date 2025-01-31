package leetcode;

public class Easy28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        int nl = needle.length();
        for (int i = 0; i < haystack.length() - nl; i++) {
            if (needle.equals(haystack.substring(i, i + nl))) {
                return i;
            }
        }
        return -1;
    }
}
