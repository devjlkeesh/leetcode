package leetcode;

public class Medium2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        while (a.next != null) {
            ListNode b = a.next;
            a.next = new ListNode(gcd(a.val, b.val), b);
            a = b;
        }
        return head;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Medium2807 m = new Medium2807();
        ListNode head = m.insertGreatestCommonDivisors(new ListNode(18, new ListNode(6, new ListNode(10,new ListNode(3)))));
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
