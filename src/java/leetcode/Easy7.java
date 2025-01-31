package leetcode;

public class Easy7 {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Easy7().reverse(123));
        System.out.println(new Easy7().reverse(-123));
    }

}
