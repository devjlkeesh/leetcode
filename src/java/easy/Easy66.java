package easy;

public class Easy66 {
    public int[] plusOne(int[] digits) {
        int rem = 0;
        int i = digits.length - 1;
        while (i >= 0) {
            int t = (digits[i] + rem);
            digits[i] = t % 10;
            rem = t / 10;
            i--;
        }
        if (rem == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = rem;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }
}
