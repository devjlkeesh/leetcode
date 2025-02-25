package leetcode;

import java.util.Arrays;

public class Medium2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int[] map = new int[100_000];
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            map[index++] = cur.val;
            cur = cur.next;
        }

        int g = 1;
        for (int i = 0; i < index-g; i++) {
            if (g % 2 == 0) {
                reverse(map, g);
            }
            g++;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < index; i++) {
            curr.next = new ListNode(map[i]);
            curr = curr.next;
        }
        return dummy.next;
    }

    static void reverse(int[] map, int g) {
        int i = g;
        int j = g * g - 1;
        while (i < j) {
            int temp = map[i];
            map[i] = map[j];
            map[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        var m = new Medium2074();
        ListNodeUtil.show(m.reverseEvenLengthGroups(ListNodeUtil.build(5,2,6,3,9,1,7,3,8,4)));
    }
}
