package leetcode;

import java.util.Stack;

public class Easy3174 {
    public String clearDigits(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] stack = new int[100];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chs[i])) {
                chs[stack[--index]] = '-';
                chs[i] = '-';
            } else {
                stack[index++] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (ch != '-') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
            Easy3174 easy3174 = new Easy3174();
            System.out.println(easy3174.clearDigits("abc"));
            System.out.println(easy3174.clearDigits("cb34"));
    }

    private void delete(char[] chs, int i) {
        chs[i] = '-';
        for (int j = i - 1; j >= 0; j--) {
            if (Character.isLetter(chs[j])) {
                chs[j] = '-';
                break;
            }
        }
    }
}
