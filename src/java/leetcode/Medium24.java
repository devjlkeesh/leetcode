package leetcode;

public class Medium24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && head.next != null) {
            cur.next = new ListNode(head.next.val, new ListNode(head.val));
            cur = cur.next.next;
            head = head.next.next;
        }
        if (head != null) {
            cur.next = new ListNode(head.val);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium24 m = new Medium24();
        var r = m.swapPairs(ListNodeUtil.build(1,2,3,4));
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
        System.out.println("--");
        r = m.swapPairs(ListNodeUtil.build(1,2));
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
        System.out.println("--");
        r = m.swapPairs(ListNodeUtil.build(1,2,3));
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
