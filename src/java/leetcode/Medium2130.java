package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Medium2130 {
    public int pairSum(ListNode head) {
        int[] m = new int[100_000];
        int sum = Integer.MIN_VALUE;
        int j =0;
        while (head != null) {
            m[j++] = head.val;
            head = head.next;
        }
        int i = 0;
        j--;
        while (i < j){
            sum =  Math.max(m[i++] + m[j--], sum);
        }
        return sum;
    }

    public int pairSum2(ListNode head) {
        int[] m = new int[100_000];
        int sum = Integer.MIN_VALUE;
        int j =0;
        while (head != null) {
            m[j++] = head.val;
            head = head.next;
        }
        int i = 0;
        j--;
        while (i < j){
            sum =  Math.max(m[i++] + m[j--], sum);
        }
        return sum;
    }
}
