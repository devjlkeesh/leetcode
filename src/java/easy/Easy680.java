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


    public boolean validPalindrome3(String s) {
        int i = 0, j = s.length() - 1;
        int t = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (!(s.charAt(i+1) == s.charAt(j) || s.charAt(j-1) == s.charAt(i))) {
                    return false;
                }i++;j--;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Easy680().validPalindrome3("aba"));
        System.out.println(new Easy680().validPalindrome3("abca"));
        System.out.println(new Easy680().validPalindrome3("abc"));
        System.out.println(new Easy680().validPalindrome3("cbbcc"));
    }
}
