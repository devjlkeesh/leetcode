package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;

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

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;

    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
