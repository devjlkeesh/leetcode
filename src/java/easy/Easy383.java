package easy;

import java.util.HashMap;
import java.util.Map;

public class Easy383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = HashMap.newHashMap(Math.min(magazine.length(), 28));
        for (char letter : magazine.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (char letter : ransomNote.toCharArray()) {
            int count = map.getOrDefault(letter, 0);
            if (count == 0) {
                return false;
            }
            map.put(letter, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Easy383 e = new Easy383();
        System.out.println(e.canConstruct("aa", "aab"));
    }
}
