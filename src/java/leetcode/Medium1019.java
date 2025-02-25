package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int grn = 0;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    grn = list.get(j);
                    break;
                }
            }
            ans[i] = grn;
        }
        return ans;
    }
}
