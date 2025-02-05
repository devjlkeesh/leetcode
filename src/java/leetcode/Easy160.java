package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Easy160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Easy160 test = new Easy160();
        // [4,1,8,4,5]
        // [5,6,1,8,4,5]
        ListNode headA = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));
        System.out.println(test.getIntersectionNode(headA, headB).val);
    }
}
