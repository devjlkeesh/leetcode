package leetcode;

public class Easy3042 {

    public int countPrefixSuffixPairs(String[] words) {
        if (words.length == 1) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
