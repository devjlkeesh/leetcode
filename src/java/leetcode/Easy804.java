package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy804 {
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        if (words.length <= 1) {
            return words.length;
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(transform(word));
        }
        return set.size();
    }

    private String transform(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(morse[word.charAt(i) - 97]);
        }
        return sb.toString();
    }
}
