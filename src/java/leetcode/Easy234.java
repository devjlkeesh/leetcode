package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Easy234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head) {
        int[] m = new int[100_000];
        int j = 0;
        while (head != null) {
            m[j++] = head.val;
            head = head.next;
        }
        int i = 0;
        j--;
        while (i < j) {
            if (m[i] != m[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
