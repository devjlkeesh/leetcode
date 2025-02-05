package leetcode;

import java.util.Arrays;

public class Medium1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int j = 0;
            while (j < boxes.length()) {
                if (j != i && boxes.charAt(j) == '1') {
                    res[i]+=Math.abs(j-i);
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1769 m = new Medium1769();
        System.out.println(Arrays.toString(m.minOperations("110")));
        System.out.println(Arrays.toString(m.minOperations("001011")));
    }
}
