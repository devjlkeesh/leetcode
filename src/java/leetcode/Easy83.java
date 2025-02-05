package leetcode;

public class Easy83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int prev = head.val;
        ListNode ans = new ListNode(prev);
        ListNode cur = ans;
        while (head != null) {
            if (prev < head.val) {
                cur.next = new ListNode(head.val);
                cur = cur.next;
                prev = head.val;
            }
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1,new ListNode(1,new ListNode(3)));
        var r = new Easy83().deleteDuplicates(n1);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
