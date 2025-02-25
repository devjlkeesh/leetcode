package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Medium143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Deque<Integer> deque = new LinkedList<>();
        ListNode cur1 = head;
        while (cur1 != null) {
            deque.push(cur1.val);
            cur1 = cur1.next;
        }
        head.val = deque.pollLast();
        head.next.val = deque.pollFirst();
        ListNode cur = head.next;
        while (!deque.isEmpty()) {
            cur.next = new ListNode(deque.pollLast());
            cur = cur.next;
            if (!deque.isEmpty()) {
                cur.next = new ListNode(deque.pollFirst());
                cur = cur.next;
            }
        }
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
    public void reorderList3(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        ListNode mid = reverse(slow);

        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < count; i++) {
            ListNode temp = cur.next;
            ListNode newNode = new ListNode(mid.val);
            newNode.next = temp;
            prev = newNode;
            cur.next = newNode;
            cur = temp;
            mid = mid.next;
        }
        if (fast != null) {
            cur.next = null;
        } else {
            prev.next = null;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode agla;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public static void main(String[] args) {
        Medium143 m = new Medium143();

        ListNode head = ListNodeUtil.build(1, 2, 3);
        m.reorderList2(head);
        ListNodeUtil.show(head);

        head = ListNodeUtil.build(1, 2, 3, 4);
        m.reorderList2(head);
        ListNodeUtil.show(head);

        head = ListNodeUtil.build(1, 2, 3, 4, 5);
        m.reorderList2(head);
        ListNodeUtil.show(head);
    }

}
