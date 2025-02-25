package leetcode;

import java.util.ArrayList;
import java.util.List;

// Given the head of a linked list, return the list after sorting it in ascending order.
public class Medium148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Integer::compare);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (Integer i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }
}
