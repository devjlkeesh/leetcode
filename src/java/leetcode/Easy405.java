package leetcode;

public class Easy405 {
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder hex = new StringBuilder();
        String hexElements = "0123456789abcdef";
        while (num != 0) {
            int lastDigit = num & 0xF;
            hex.append(hexElements.charAt(lastDigit));
            num >>>= 4;
        }
        return hex.reverse().toString();
    }
}
