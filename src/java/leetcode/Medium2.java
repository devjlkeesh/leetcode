package leetcode;

public class Medium2 {
    /*
    You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order, and each of their nodes contains a single digit.
     Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Medium2 m = new Medium2();
        ListNodeUtil.show(m.addTwoNumbers(ListNodeUtil.build(2, 4, 3), ListNodeUtil.build(5, 6, 4)));
    }
}
