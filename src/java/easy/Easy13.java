package easy;

public class Easy13 {

    public int romanToInt(String s) {
        int prev = 0;
        int result = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (digit < prev) {
                result = result - digit;
                prev = digit;
            } else {
                result = result + digit;
                prev = digit;
            }
        }
        return result;
    }

}
