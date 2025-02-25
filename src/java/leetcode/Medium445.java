package leetcode;

public class Medium445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0 && l2.val==0){
            return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val + l2.val + carry;
            carry = a / 10;
            cur.next = new ListNode(a % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int a = l1.val + carry;
            carry = a / 10;
            cur.next = new ListNode(a % 10);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int a = l2.val + carry;
            carry = a / 10;
            cur.next = new ListNode(a % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        dummy = dummy.next;
        dummy = reverse(dummy);
        if (dummy.val == 0) return dummy.next;
        return  dummy;
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
        Medium445 m = new Medium445();
        ListNodeUtil.show(m.addTwoNumbers(ListNodeUtil.build(7, 2, 4, 3), ListNodeUtil.build(5, 6, 4)));
    }
}
