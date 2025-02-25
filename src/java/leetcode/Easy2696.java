package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Easy2696 {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == 'B' && stack.peek() == 'A' || c == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Easy2696 demo = new Easy2696();
        System.out.println(demo.minLength("ACBBD"));
    }
}
