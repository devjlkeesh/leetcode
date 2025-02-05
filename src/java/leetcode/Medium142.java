package leetcode;

import java.util.HashMap;

public class Medium142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            int o = System.identityHashCode(head);
            if (map.containsKey(o)) {
                return map.get(o);
            }
            map.put(o, head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}
