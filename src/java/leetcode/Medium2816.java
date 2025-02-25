package leetcode;

public class Medium2816 {
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        if (head.val == 0 && head.next == null) {
            return head;
        }
        int carry = 0;
        var node = reverseList(head);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node != null) {
            int a = (node.val * 2 + carry);
            carry = a / 10;
            cur.next = new ListNode(a % 10);
            cur = cur.next;
            node = node.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        var response = reverseList(dummy.next);
        if (response.val == 0){
            return response.next;
        }
        return response;
    }

    public static void main(String[] args) {
        Medium2816 m = new Medium2816();
        ListNodeUtil.show(m.doubleIt(ListNodeUtil.build(1,8,9)));
        ListNodeUtil.show(m.doubleIt(ListNodeUtil.build(9,9)));
        ListNodeUtil.show(m.doubleIt(ListNodeUtil.build(9,9,9)));
    }
}
