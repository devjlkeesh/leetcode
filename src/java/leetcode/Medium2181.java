package leetcode;

public class Medium2181 {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                if (sum != 0) {
                    cur.next = new ListNode(sum);
                    cur = cur.next;
                    sum = 0;
                }
            }else{
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Medium2181 m = new Medium2181();
        //[0,3,1,0,4,5,2,0]
        ListNode head = m.mergeNodes(new ListNode(0, new ListNode(3,new ListNode(1, new ListNode(0,new ListNode(4, new ListNode(5,new ListNode(2, new ListNode(0)))))))));
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
