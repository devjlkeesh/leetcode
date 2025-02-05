package leetcode;

public class Medium1966 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode dummy = list1;
        ListNode cur = dummy;
        while (i < a) {
            cur = cur.next;
            list1 = list1.next;
            i++;
        }
        cur.next = list2;
        while (cur.next != null) cur = cur.next;
        while (i <= b && list1 != null) {
            list1 = list1.next;
            i++;
        }
        cur.next = list1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium1966 m = new Medium1966();
        //list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
        ListNode list1 = new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(6, new ListNode(9, new ListNode(5))))));
        ListNode list2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        var r = m.mergeInBetween(list1, 3, 4, list2);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
