package easy;

public class Easy2185 {
    public int prefixCount(String[] words, String pref) {
        if (pref.isEmpty()) {
            return words.length;
        }
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

}
