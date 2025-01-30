package medium;

import java.util.ArrayList;
import java.util.List;

public class Medium3324 {


    public List<String> stringSequence2(String target) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        int ii = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            s.append('a');
            for (char j = 'a'; j <= c; j++) {
                s.setCharAt(ii, j);
                res.add(s.toString());
            }
            ii++;
            // ["a","a","b","a","b","c"]
        }
        return res;
    }

    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder screen = new StringBuilder();
        for (char c : target.toCharArray()) {
            screen.append('a');
            result.add(screen.toString());
            char j = 'a';
            while (j != c) {
                j = (char) (j + 1);
                screen.setCharAt(screen.length() - 1, j);
                result.add(screen.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Medium3324 m = new Medium3324();
        System.out.println(m.stringSequence("he"));
        System.out.println(m.stringSequence2("abc"));
        System.out.println(m.stringSequence("abc"));
    }
}
