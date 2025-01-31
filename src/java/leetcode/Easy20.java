package leetcode;

import java.util.Stack;

public class Easy20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                int a = stack.pop() + c;
                if (!(a == 81 || a == 248 || a == 184)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Easy20 easy20 = new Easy20();
        System.out.println(easy20.isValid("(]"));
    }
}
