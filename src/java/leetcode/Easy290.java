package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                if (map.get(word) != pattern.charAt(i)) return false;
            }else{
                if (set.contains(pattern.charAt(i))) return false;
                set.add(pattern.charAt(i));
                map.put(word, pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy290 demo = new Easy290();
        System.out.println(demo.wordPattern("abba", "dog cat cat dog"));
        System.out.println(demo.wordPattern("aba", "dog cat cat cat"));
        System.out.println(demo.wordPattern("aba", "dog cat cat"));
        System.out.println(demo.wordPattern("abba", "dog cat cat fish"));
    }
}
