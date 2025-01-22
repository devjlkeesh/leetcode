package easy;

public class Easy125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char lc = s.charAt(i);
            if (!((lc >= 'A' && lc <= 'Z') || (lc >= 'a' && lc <= 'z') || (lc >= '0' && lc <= '9'))) {
                i++;
                continue;
            }
            char rc = s.charAt(j);
            if (!((rc >= 'A' && rc <= 'Z') || (rc >= 'a' && rc <= 'z') || (rc >= '0' && rc <= '9'))) {
                j--;
                continue;
            }
            if (lc >= 'a') {
                lc = (char) (lc - 32);
            }
            if (rc >= 'a') {
                rc = (char) (rc - 32);
            }
            if (lc != rc) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Easy125 test = new Easy125();
        System.out.println(test.isPalindrome("aba"));
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
        System.out.println(test.isPalindrome(" "));
    }
}
