package leetcode;

import java.util.Stack;

public class Easy1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && c == sb.charAt(sb.length() - 1)) {
                sb.setLength(sb.length() - 1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates3(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (char c : chars) {
            if (i > 0 && c == chars[i - 1]) {
                i--;
            }else{
                chars[i++] = c;
            }
        }
        return new String(chars, 0, i);
    }

    public static void main(String[] args) {
        Easy1047 demo = new Easy1047();
        System.out.println(demo.removeDuplicates("abb"));
        System.out.println(demo.removeDuplicates("abbaca"));
    }
}
