package leetcode;

import java.util.Stack;

public class Easy2000 {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        if (ind < 0) {
            return word;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= ind; i++) {
            stack.push(word.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append(word.substring(ind));
        return sb.toString();
    }
    public String reversePrefix2(String word, char ch) {
        int ind = word.indexOf(ch);
        if (ind < 0) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word);
        int j = 0;
        for (int i = ind; i >=0; i--) {
            sb.setCharAt(j++, word.charAt(i));
        }
        return sb.toString();
    }

}
