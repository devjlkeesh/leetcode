package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Easy989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carrier = 0;
        int i = num.length - 1;
        List<Integer> result = new ArrayList<>();
        while (i >= 0 || k > 0 || carrier > 0) {
            int sum = carrier;
            if (i >= 0) {
                sum += num[i--];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            result.add(sum % 10);
            carrier = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Easy989 e = new Easy989();
        System.out.println("e.addToArrayForm(new int[]{1 2, 0,0}, 34) = " + e.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println("e.addToArrayForm(new int[]{1, 2, 0,0}, 34) = " + e.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println("e.addToArrayForm(new int[]{1, 2, 0,0}, 34) = " + e.addToArrayForm(new int[]{0}, 23));
        System.out.println("e.addToArrayForm(new int[]{1, 2, 0,0}, 34) = " + e.addToArrayForm(new int[]{8}, 996));

    }
}
