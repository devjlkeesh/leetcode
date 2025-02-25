package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium147 {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Integer::compareTo);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (Integer i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium147 m = new Medium147();
        ListNodeUtil.show(m.insertionSortList2(ListNodeUtil.build(3,6,1)));
    }

}
