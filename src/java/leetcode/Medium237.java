package leetcode;

public class Medium237 {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = node;
        while (cur.next != null) {
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
    }

    public static void main(String[] args) {
        Medium237 m = new Medium237();
        //[4,5,1,9]
        ListNode node = new ListNode(5, new ListNode(1, new ListNode(9)));
        ListNode head = new ListNode(4, node);
        m.deleteNode(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
