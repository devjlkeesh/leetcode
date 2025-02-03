package leetcode;

public class Medium725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        ListNode[] ans = new ListNode[k];
        curr = head;
        if (count < k) {
            for (int i = 0; i < count && curr != null; i++) {
                ans[i] = new ListNode(curr.val);
                curr = curr.next;
            }
        } else {
            for (int i = 0; i < k; i++) {
                int t = (count % k > i) ? Math.ceilDiv(count, k) : count / k;
                ListNode nthNode = new ListNode(0);
                ListNode trace = nthNode;
                for (int l = 0; l < t && curr != null; l++) {
                    trace.next = new ListNode(curr.val);
                    trace = trace.next;
                    curr = curr.next;
                }
                ans[i] = nthNode.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Medium725 m = new Medium725();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode[] listNodes = m.splitListToParts(head, 5);
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            while (listNode != null) {
                System.out.println(listNode.val);
                listNode = listNode.next;
            }

        }
        System.out.println("dsfsd");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        listNodes = m.splitListToParts(head, 3);
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();

        }
        System.out.println("dsfsd");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        listNodes = m.splitListToParts(head, 3);
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();

        }
        System.out.println("dsfsd");
        head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        listNodes = m.splitListToParts(head, 3);
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();

        }
    }
}
