package easy;

public class Easy504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            result.append(num % 7);
            num /= 7;
        }
        if (negative) {
            result.append('-');
        }
        return result.reverse().toString();
    }
}
