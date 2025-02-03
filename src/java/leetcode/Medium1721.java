package leetcode;

public class Medium1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int[] m = new int[100_001];
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            m[count++] = curr.val;
            curr = curr.next;
        }
        int temp = m[k];
        m[k] = m[count-k];
        m[count-k] = temp;
        ListNode newHead = head;
        curr = newHead;
        for (int i = 1; i < count; i++) {
            curr.next = new ListNode(m[i]);
            curr = curr.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Medium1721 m = new Medium1721();
        ListNodeUtil.show(m.swapNodes(ListNodeUtil.build(1,2,3,4), 1));
        ListNodeUtil.show(m.swapNodes(ListNodeUtil.build(1,2,3,4,5), 2));
        ListNodeUtil.show(m.swapNodes(ListNodeUtil.build(7,9,6,6,7,8,3,0,9,5), 5));
    }
}
