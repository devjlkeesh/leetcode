package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Easy1002 {
    public List<String> commonChars(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();
        String first = words[0];
        for (char c : first.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (char c : word.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }
            map.forEach((k, v) -> {
                if (!map2.containsKey(k)) {
                    map.put(k, 0);
                }else{
                    map.put(k, Math.min(map2.get(k), v));
                }
            });
        }
        List<String> ans = new ArrayList<>();
        map.forEach((k, v) -> {
            for (int i = 0; i < v / words.length; i++) {
                ans.add(String.valueOf(k));
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        Easy1002 demo = new Easy1002();
        System.out.println(demo.commonChars(new String[]{"ab", "b", "c", "d", "e", "f"}));
        System.out.println(demo.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(demo.commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
    }
}
