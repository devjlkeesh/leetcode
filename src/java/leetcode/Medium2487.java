package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Medium2487 {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        int[] map = new int[100_000];
        int index = 0;
        while (head != null) {
            map[index++] = head.val;
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        index--;
        while (index >= 0) {
            int val = map[index--];
            if (val >= max) {
                curr.next = new ListNode(val);
                curr = curr.next;
                max = val;
            }
        }
        return reverse(dummy.next);
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Medium2487 m = new Medium2487();
        ListNodeUtil.show(m.removeNodes(ListNodeUtil.build(5, 2, 13, 3, 8)));
        ListNodeUtil.show(m.removeNodes(ListNodeUtil.build(5, 5)));
    }
}
