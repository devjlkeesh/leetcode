package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy2788 {
    /*
    Given an array of strings words and a character separator, split each string in words by separator.

    Return an array of strings containing the new strings formed after the splits, excluding empty strings.

            Notes

    separator is used to determine where the split should occur, but it is not included as part of the resulting strings.
    A split may result in more than two strings.
    The resulting strings must maintain the same order as they were initially given.


            Example 1:

    Input: words = ["one.two.three","four.five","six"], separator = "."
    Output: ["one","two","three","four","five","six"]
    Explanation: In this example we split as follows:

            "one.two.three" splits into "one", "two", "three"
            "four.five" splits into "four", "five"
            "six" splits into "six"
            Hence, the resulting array is ["one","two","three","four","five","six"].
*/

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (!sb.isEmpty()){
                        res.add(sb.toString());sb = new StringBuilder();
                    }
                }else{
                    sb.append(ch);
                }
            }
            if (!sb.isEmpty()){
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy2788 demo = new Easy2788();
        System.out.println(demo.splitWordsBySeparator(Arrays.asList("one.two.three","four.five","six"), '.'));
    }

}
