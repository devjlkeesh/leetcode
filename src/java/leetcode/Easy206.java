package leetcode;

public class Easy206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            dummy = new ListNode(head.val,dummy);
            head = head.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        Easy206 easy206 = new Easy206();
        ListNode n1 = new ListNode(4,new ListNode(1,new ListNode(2,new ListNode(3))));
        ListNode head = easy206.reverseList(n1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
