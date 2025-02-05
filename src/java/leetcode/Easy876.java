package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy876 {
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(new ListNode(head.val));
            head = head.next;
        }
        return nodes.get(nodes.size() / 2);
    }
}
