package easy;

public class Easy9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int temp = x;
        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == result;
    }

    public static void main(String[] args) {
        Easy9 easy9 = new Easy9();
        System.out.println(easy9.isPalindrome(121));
        System.out.println(easy9.isPalindrome(10));
    }
}
