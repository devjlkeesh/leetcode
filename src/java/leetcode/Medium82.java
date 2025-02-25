package leetcode;
// Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list. Return the linked list sorted as well.
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]


public class Medium82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        int[] map = new int[201];
        while (head != null) {
            if (map[head.val + 100] == 0) {
                map[head.val + 100] = 1;
            }
            else if (map[head.val + 100] == 1) {
                map[head.val + 100] = -1;
            }
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                cur.next = new ListNode(i-100);
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (head != null) {
            boolean flag = false;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                flag = true;
            }
            if (!flag) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean flag = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                flag = true;
            }
            if (flag) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium82 m = new Medium82();
        ListNodeUtil.show(m.deleteDuplicates(ListNodeUtil.build(1,2,3,3,4,4,5)));
        ListNodeUtil.show(m.deleteDuplicates2(ListNodeUtil.build(1,2,3,3,4,4,5)));
        ListNodeUtil.show(m.deleteDuplicates3(ListNodeUtil.build(1,2,3,3,4,4,5)));
    }
}
