package easy;

public class Easy3079 {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int maxDigit = 0;
            int digitCount = 0;
            while (num > 0) {
                maxDigit = Math.max(maxDigit, num % 10);
                num /= 10;
                digitCount++;
            }
            int i = 1;
            while (digitCount >= 0) {
                sum += maxDigit * i;
                digitCount--;
            }
        }
        return sum;
    }
}
