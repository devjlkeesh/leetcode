package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Medium3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        //int[] m = new int[100_001];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
