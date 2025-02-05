package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy2855 {
    public int minimumRightShifts(List<Integer> nums) {
        int idx = -1;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i-1) > nums.get(i)) {
                if (idx != -1) {
                    return -1;
                }
                idx = i;
            }
        }
        if (idx == -1) return 0;
        if (nums.get(n - 1) > nums.get(0))return -1;
        return n - idx;
    }

    public static void main(String[] args) {
        Easy2855 e = new Easy2855();
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        System.out.println(e.minimumRightShifts(nums));
        System.out.println(e.minimumRightShifts(List.of(2,1,4)));
        System.out.println(e.minimumRightShifts(List.of(1,2,4)));
    }
}
