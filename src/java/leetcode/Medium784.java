package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium784 {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        answer.add(s);
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            //kichik
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.setCharAt(i, Character.toLowerCase(c));
            }
            for (int j = 0; j < s.length() && i!=j ; j++) {
                char ch = sb.charAt(j);
                if (Character.isLowerCase(ch)) {
                    sb.setCharAt(j, (char) (ch - 32));
                } else if (Character.isUpperCase(ch)) {
                    sb.setCharAt(j, (char) (ch + 32));
                }
                if (!answer.contains(sb.toString())) {
                    answer.add(sb.toString());
                }
            }
            if (!answer.contains(sb.toString())) {
                answer.add(sb.toString());
            }
            //katta
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            }
            for (int j = 0; j < s.length() && i!=j ; j++) {
                char ch = sb.charAt(j);
                if (Character.isLowerCase(ch)) {
                    sb.setCharAt(j, (char) (ch - 32));
                } else if (Character.isUpperCase(ch)) {
                    sb.setCharAt(j, (char) (ch + 32));
                }
                if (!answer.contains(sb.toString())) {
                    answer.add(sb.toString());
                }
            }
            if (!answer.contains(sb.toString())) {
                answer.add(sb.toString());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Medium784 m = new Medium784();
        System.out.println(m.letterCasePermutation("a1b2"));
        System.out.println(m.letterCasePermutation("3z4"));
        System.out.println(m.letterCasePermutation("C"));
//        Output: ["a1b2","a1B2","A1b2","A1B2"]

    }
}
