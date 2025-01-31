package leetcode;

public class Easy415 {
    public String addStrings(String num1, String num2) {
        int n = num1.length() - 1, m = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 0 || m >= 0 || carry > 0) {
            int i = n >= 0 ? num1.charAt(n--) - '0' : 0;
            int j = m >= 0 ? num2.charAt(m--) - '0' : 0;
            int sum = i + j + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString();
    }

}
