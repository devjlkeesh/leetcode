package easy;

public class Easy680 {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }

    public boolean validPalindrome(String s, int i, int j, boolean att) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (att) {
                    return false;
                }
                return validPalindrome(s, i + 1, j, true) || validPalindrome(s, i, j - 1, true);
            }
            i++;
            j--;
        }
        return true;
    }

}
