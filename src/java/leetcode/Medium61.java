package leetcode;

import java.util.Arrays;
import java.util.List;

/*
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
*/
public class Medium61 {
    public ListNode rotateRight(ListNode head, int k) {
        int[] nums = new int[501];
        int i = 0;
        while (head != null) {
            nums[i++] = head.val;
            head = head.next;
        }
        k = k % i;
        int[] m = new int[k];
        System.out.println("i = " + i);
        for (int j = 0; j < k ; j++) {
            m[j] = nums[i-k+j];
        }
        System.out.println(Arrays.toString(m));
        for (int j = i - 1; j >= k; j--) {
            nums[j] = nums[j - k];
        }
        System.out.println(Arrays.toString(nums));
        for (int j = 0; j < k ; j++) {
            nums[j] = m[j];
        }
        System.out.println(Arrays.toString(nums));
        return null;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int[] nums = new int[501];
        int n = 0;
        while (head != null) {
            nums[n++] = head.val;
            head = head.next;
        }
        k = k % n;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int j = 0; j < k ; j++) {
            curr.next = new ListNode(nums[n-k+j]);
            curr = curr.next;
        }

        for (int j = 0; j < n - k; j++) {
            curr.next = new ListNode(nums[j]);
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 ) return head;
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        k = k % n;
        if (k == 0) return head;
        ListNode newTail = head;
        for (int j = 0; j < n - k - 1 ; j++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;

    }

    public static void main(String[] args) {
        Medium61 m = new Medium61();
        ListNodeUtil.show(m.rotateRight2(ListNodeUtil.build(1, 2, 3, 4, 5), 2));
        //Input: head = [0,1,2], k = 4
        //Output: [2,0,1]
        ListNodeUtil.show(m.rotateRight2(ListNodeUtil.build(0,1, 2), 4));
    }
}
