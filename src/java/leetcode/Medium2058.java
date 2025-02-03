package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next.next == null) {
            return new int[]{-1, -1};
        }
        int prevVal = head.val;
        ListNode curr = head.next;
        List<Integer> list = new ArrayList<>();
        int c = 1;
        int firstVal = -1;
        int lastVal = -1;
        int min = 100_001;

        while (curr.next != null) {
            int currVal = curr.val;
            int nextVal = curr.next.val;
            if (prevVal < currVal && currVal > nextVal || prevVal > currVal && currVal < nextVal) {
                if (firstVal == -1) {
                    firstVal = c;
                }
                if (lastVal != -1) {
                    min = Math.min(min, c - lastVal);
                }
                lastVal = c;
            }
            c++;
            curr = curr.next;
            prevVal = currVal;
        }
        System.out.println("firstVal = " + firstVal);
        System.out.println("lastVal = " + lastVal);
//        if (list.size() < 2) {
//            return new int[]{-1, -1};
//        }
        /*if (list.size() == 2) {
            return new int[]{list.get(1) - list.get(0), list.get(1) - list.get(0)};
        }
        int min = Integer.MAX_VALUE;
        int max = list.get(list.size()-1)-list.get(0);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i+1) - list.get(i) < min) {
                min = list.get(i+1) - list.get(i);
            }
        }
        return new int[]{min,max};*/
        return new int[]{min, lastVal - firstVal};
    }

    public int[] nodesBetweenCriticalPoints2(ListNode head) {
        if (head.next.next == null) {
            return new int[]{-1, -1};
        }
        int prevVal = head.val;
        ListNode curr = head.next;
        int c = 1;
        int firstVal = -1;
        int lastVal = -1;
        int min = 100_001;

        while (curr.next != null) {
            int currVal = curr.val;
            int nextVal = curr.next.val;
            if (prevVal < currVal && currVal > nextVal || prevVal > currVal && currVal < nextVal) {
                if (firstVal == -1) {
                    firstVal = c;
                }
                if (lastVal != -1) {
                    min = Math.min(min, c - lastVal);
                }
                lastVal = c;
            }
            c++;
            curr = curr.next;
            prevVal = currVal;
        }
        if (min == 100_001) {
            return new int[]{-1, -1};
        }
        return new int[]{min, lastVal - firstVal};
    }

    public static void main(String[] args) {
        Medium2058 m = new Medium2058();
        //Input: head = [5,3,1,2,5,1,2]
        ListNode head = new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(1, new ListNode(2)))))));
        int[] ints = m.nodesBetweenCriticalPoints2(head);
        System.out.println(Arrays.toString(ints));
        //[6,8,4,1,9,6,6,10,6]
        // [1,6]
        var nn = build(new int[]{6, 8, 4, 1, 9, 6, 6, 10, 6});
        System.out.println(Arrays.toString(m.nodesBetweenCriticalPoints2(nn)));
//        System.out.println(Arrays.toString(m.nodesBetweenCriticalPoints(build(new int[]{2,3,3,2}))));
        System.out.println(Arrays.toString(m.nodesBetweenCriticalPoints2(build(new int[]{2, 3, 3, 2}))));
        System.out.println(Arrays.toString(m.nodesBetweenCriticalPoints2(build(new int[]{2, 2, 1, 3}))));

    }

    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }
}
