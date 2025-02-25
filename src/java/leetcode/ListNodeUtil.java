package leetcode;

import java.util.StringJoiner;

public class ListNodeUtil {
    public static ListNode build(int... arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void show(ListNode listNode) {
        System.out.println("------------");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
        System.out.println("============");
    }

    public static String toString(ListNode listNode) {
        StringJoiner sj = new StringJoiner(" ", "[", "]");
        while (listNode != null) {
            sj.add(listNode.val + "");
            listNode = listNode.next;
        }
        return sj.toString();
    }
    public static String toString(DoublyListNode listNode) {
        StringJoiner sj = new StringJoiner(" ", "[", "]");
        while (listNode != null) {
            sj.add(listNode.val + "");
            listNode = listNode.next;
        }
        return sj.toString();
    }
}
