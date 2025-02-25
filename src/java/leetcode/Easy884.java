package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            if (map.containsKey(s)) {
                map.put(s, -1);
            } else {
                map.put(s, 0);
            }
        }
        for (String s : s2.split(" ")) {
            if (map.containsKey(s)) {
                map.put(s, -1);
            } else {
                map.put(s, 0);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Easy884 test = new Easy884();
        System.out.println(test.uncommonFromSentences("fd kss fd","fd fd kss"));
    }
}
