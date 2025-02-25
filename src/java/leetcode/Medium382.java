package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Medium382 {
    public static class Solution {
        private int size;
        private final List<Integer> nums = new ArrayList<>();
        private final Random random;

        public Solution(ListNode head) {
            while (head != null) {
                nums.add(head.val);
                head = head.next;
                size++;
            }
            this.random = new Random();
        }

        public int getRandom() {
            return nums.get(random.nextInt(size));
        }
    }

    public static void main(String[] args) {
        var m = new Solution(ListNodeUtil.build(10,1,10,20,100));
        System.out.println(m.getRandom());
        System.out.println(m.getRandom());
        System.out.println(m.getRandom());
        System.out.println(m.getRandom());
        System.out.println(m.getRandom());
    }
}
