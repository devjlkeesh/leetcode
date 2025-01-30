package easy;

import java.util.ArrayList;
import java.util.List;

public class Easy500 {
    public String[] findWords(String[] words) {
        int[] row = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        List<String> wordList = new ArrayList<>(words.length);
        for (String word : words) {
            int rowNumberCount = 0;
            int rowNumber = 0;
            for (int c : word.toCharArray()) {
                if (c > 90) {
                    c -= 32;
                }
                c -= 65;
                if (rowNumber != row[c]) {
                    rowNumberCount++;
                    rowNumber = row[c];
                }
            }
            if (rowNumberCount == 1) {
                wordList.add(word);
            }
        }
        return wordList.toArray(new String[0]);
    }

    public static void main(String[] args) {

        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print((i - 'A') + ", ");
        }
        System.out.println();
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print((i - 'a') + ", ");
        }
        System.out.println();
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }
}
