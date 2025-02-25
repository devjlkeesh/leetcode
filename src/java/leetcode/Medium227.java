package leetcode;

import java.util.Stack;

public class Medium227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        int n = 0;
        char l = '+';
        while (i < chars.length) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                var t = getNumber(i, chars);
                n = t[0];
                i = t[1] - 1;
            }
            if (c == '/' || c == '*' || c == '+' || c == '-' || i == chars.length - 1) {
                if (l == '*') {
                    stack.push(stack.pop() * n);
                } else if (l == '/') {
                    stack.push(stack.pop() / n);
                } else if (l == '+') {
                    stack.push(n);
                } else if (l == '-') {
                    stack.push(-n);
                }
                l = c;
                n = 0;
            }
            i++;
        }
        int sum = 0;
        for (Integer integer : stack) sum += integer;
        return sum;
    }

    public int calculate2(String s) {
        int[] stack = new int[s.length() + 1];
        int j = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        int n = 0;
        char l = '+';
        while (i < chars.length) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                while (i < chars.length && Character.isDigit(chars[i])) {
                    n = n * 10 + chars[i++] - '0';
                }
                --i;
            }
            if (c == '/' || c == '*' || c == '+' || c == '-' || i == chars.length - 1) {
                if (l == '*') {
                    stack[j - 1] = stack[j - 1] * n;
                } else if (l == '/') {
                    stack[j - 1] = stack[j - 1] / n;
                } else if (l == '+') {
                    stack[j++] = n;
                } else if (l == '-') {
                    stack[j++] = -n;
                }
                l = c;
                n = 0;
            }
            i++;
        }
        // 2*3*4
        int sum = 0;
        for (int k = 0; k <= j; k++) sum += stack[k];
        return sum;
    }

    private int[] getNumber(int i, char[] chars) {
        int num = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            num = num * 10 + chars[i++] - '0';
        }
        return new int[]{num, i};
    }

    public static void main(String[] args) {
        Medium227 m = new Medium227();
        System.out.println(m.calculate("3+2*2"));
        System.out.println(m.calculate("3+5 / 2 "));
        System.out.println(m.calculate("5 / 2 "));
        System.out.println(m.calculate(" 3/2 "));
        System.out.println(m.calculate("0-2147483647"));
        System.out.println("--");
        System.out.println(m.calculate2("3+2*2"));
        System.out.println(m.calculate2("3+5 / 2 "));
        System.out.println(m.calculate2("5 / 2 "));
        System.out.println(m.calculate2(" 3/2 "));
        System.out.println(m.calculate2("0-2147483647"));
        System.out.println(m.calculate2("2*3*4"));
    }
}
