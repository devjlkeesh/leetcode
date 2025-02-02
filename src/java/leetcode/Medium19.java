package leetcode;

public class Medium19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int[] nums = new int[31];
        int i = 0;
        while (cur != null) {
            nums[i++] = cur.val;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        cur = dummy;
        System.out.println(i);
        System.out.println(n);
        for (int j = 0; j < i; j++) {
            if (j != i-n) {
                cur.next = new ListNode(nums[j]);
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium19 m = new Medium19();
        //[1,2,3,4,5]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode r = m.removeNthFromEnd(head, 2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
