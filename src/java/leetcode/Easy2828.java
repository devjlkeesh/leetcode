package leetcode;

import java.util.List;

public class Easy2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (s.isEmpty() || words.size() != s.length())return false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Easy2828 demo = new Easy2828();
        System.out.println(demo.isAcronym(List.of("alice","bob","charlie"),"abc"));
    }
}
