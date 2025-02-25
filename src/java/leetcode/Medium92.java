package leetcode;

/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
*/
public class Medium92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int cnt = 1;
        for (int i = 1; i < left; i++) {
            curr.next = head;
            curr = curr.next;
            cnt++;
            head = head.next;
        }

        ListNode prev = null;


        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.build(1, 2, 3, 4, 5);
        ListNode reversed = reverse(head);
        ListNodeUtil.show(reversed);
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
