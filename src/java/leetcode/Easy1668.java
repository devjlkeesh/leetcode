package leetcode;

public class Easy1668 {

    public int maxRepeating(String sequence, String word) {
//        int k = 0;
//        StringBuilder t = new StringBuilder(word);
//        while (sequence.contains(t)) {
//            k++;
//            t.append(word);
//        }
//        return k;
        return 0;
    }

    public int maxRepeating2(String sequence, String word) {
        return maxRepeating(sequence, word,0);
    }

    public int maxRepeating(String sequence, String word, int k) {
        if (sequence.contains(word)) {
            return maxRepeating(sequence, word + word, k + 1);
        }
        return k;
    }

    public static void main(String[] args) {
        Easy1668 demo = new Easy1668();
        System.out.println(demo.maxRepeating("abba", "abba"));
        System.out.println(demo.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        System.out.println(demo.maxRepeating2("abba", "abba"));
        System.out.println(demo.maxRepeating2("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
