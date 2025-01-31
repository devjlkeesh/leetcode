package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy718 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        out:
        for (int i = left; i <= right; i++) {
            int num = i;
            while (num > 0) {
                int lastDigit = num % 10;
                if (lastDigit == 0 || i % lastDigit != 0) {
                    continue out;
                }
                num /= 10;
            }
            result.add(i);
        }
        //[1,2,3,4,5,6,7,8,9,11,12,15,22]
        //[1,2,3,4,5,6,7,8,9,11,12,15,22]
        return result;
    }

    public static void main(String[] args) {
        Easy718 demo = new Easy718();
        List<Integer> result = demo.selfDividingNumbers(47, 85);
        System.out.println(result);
    }
}
