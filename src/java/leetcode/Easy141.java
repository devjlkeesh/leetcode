package leetcode;

import java.util.HashSet;

public class Easy141 {
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        while (head != null) {
            int o = System.identityHashCode(head);
            if (set.contains(o)) {
                return true;
            }
            set.add(o);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        n2.next = n1;
        System.out.println(new Easy141().hasCycle(n1));
    }
}
