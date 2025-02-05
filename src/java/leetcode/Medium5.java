package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Medium5 {
    Set<String> result = new HashSet<>();

    public String longestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        search(s, i, j);
        String a = "";
        for (String string : result) {
            if (string.length() > a.length()) {
                a = string;
            }
        }
        return a;
    }

    void search(String s, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                result.add(s.substring(start, end));
                search(s, start + 1, end);
                search(s, start, end - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Medium5 m = new Medium5();
        System.out.println(m.longestPalindrome("babad"));
    }
}
