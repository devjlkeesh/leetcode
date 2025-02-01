package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        System.out.println(paragraph);
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        StringBuilder sb = new StringBuilder();
        for (int c : paragraph.toCharArray()) {
            if ((c == ' ' || c == '!' || c == '?' || c == ',' || c == ';' || c == '.') && !sb.isEmpty()) {
                if (!set.contains(sb.toString())) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }
                sb = new StringBuilder();
            }
            if (Character.isLetter(c)) {
                sb.append((char) (c + (c < 'a' ? 32 : 0)));
            }
        }
        System.out.println(map
        );
        String w = sb.toString();
        if (w.isEmpty() || set.contains(w)) {
            return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        }
        map.put(w, map.getOrDefault(w, 0) + 1);
        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static void main(String[] args) {
        Easy819 demo = new Easy819();
        System.out.println(demo.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(demo.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}
