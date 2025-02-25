package leetcode;

import java.util.Stack;

public class Medium1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char ch : sb.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String reverseParentheses2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                StringBuilder it = new StringBuilder();
                int j;
                for (j = sb.length() - 1; j >= 0; j--) {
                    if (sb.charAt(j) == '(') break;
                    it.append(sb.charAt(j));
                }
                sb.setLength(j);
                sb.append(it);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses3(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            } else if (c == ')') {
                curr.reverse();
                curr = stack.pop().append(curr);
            } else curr.append(c);
        }

        return curr.toString();
    }

    public static void main(String[] args) {
        Medium1190 m = new Medium1190();
        System.out.println(m.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(m.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(m.reverseParentheses("ta()usw((((a))))"));
        System.out.println("------------------------------------------------");
        System.out.println(m.reverseParentheses2("(ed(et(oc))el)"));
        System.out.println(m.reverseParentheses2("a(bcdefghijkl(mno)p)q"));
        System.out.println(m.reverseParentheses2("ta()usw((((a))))"));
        System.out.println("------------------------------------------------");
        System.out.println(m.reverseParentheses3("(ed(et(oc))el)"));
        System.out.println(m.reverseParentheses3("a(bcdefghijkl(mno)p)q"));
        System.out.println(m.reverseParentheses3("ta()usw((((a))))"));

    }
}
