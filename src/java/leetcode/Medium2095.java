package leetcode;

public class Medium2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        Medium2095 medium2095 = new Medium2095();
        ListNodeUtil.show(medium2095.deleteMiddle(ListNodeUtil.build(1,2,3,4)));
        ListNodeUtil.show(medium2095.deleteMiddle(ListNodeUtil.build(1,3,4,7,1,2,6)));
    }
}
