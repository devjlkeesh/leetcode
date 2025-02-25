package leetcode;

public class Medium328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(0);
        ListNode evenCur = even;
        ListNode odd = new ListNode(0);
        ListNode oddCur = odd;
        int cnt = 0;
        while (head != null) {
            if (cnt % 2 == 0) {
                evenCur.next = new ListNode(head.val);
                evenCur = evenCur.next;
            } else {
                oddCur.next = new ListNode(head.val);
                oddCur = oddCur.next;
            }
            head = head.next;
            cnt++;
        }
        even.next = odd.next;
        return even.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Medium328 m = new Medium328();
        ListNode head = ListNodeUtil.build(1, 2, 3, 4, 5, 6);
        ListNodeUtil.show(head);
        ListNodeUtil.show(m.oddEvenList2(head));
    }
}
