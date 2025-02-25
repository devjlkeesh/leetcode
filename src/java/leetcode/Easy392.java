package leetcode;

public class Easy392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) return true;
        if (n > m) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
    public boolean isSubsequence2(String s, String t, int i, int j) {
        if (i == s.length()) return true;
        if (j == t.length()) return false;
        if (s.charAt(i) == t.charAt(j)) {
            return isSubsequence2(s,t,i+1,j+1);
        }
        return isSubsequence2(s,t,i,j+1);
    }

    public static void main(String[] args) {
        System.out.println(new Easy392().isSubsequence("abc", "cba"));
        System.out.println(new Easy392().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Easy392().isSubsequence("abc", "ahbgdc"));
    }
}
