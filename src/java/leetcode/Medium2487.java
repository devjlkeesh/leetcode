package leetcode;

public class Medium2487 {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curr = head;
        int[] m = new int[100_000];
        int i = 0;
        while (curr != null) {
            m[i++] = curr.val;
            curr = curr.next;
        }
        ListNode dummy = new ListNode(0);
        curr = dummy;
        out:
        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {
                if (m[j] < m[k]) {
                    continue out;
                }
            }
            curr.next = new ListNode(m[j]);
            curr = curr.next;
        }
        return dummy.next;
    }
}
