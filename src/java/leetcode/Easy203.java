package leetcode;

public class Easy203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (head.val != val) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
