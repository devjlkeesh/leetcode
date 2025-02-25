package leetcode;

public class Medium86 {
    //Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    //You should preserve the original relative order of the nodes in each of the two partitions.
/*
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]

*/
    public ListNode partition(ListNode head, int x) {
        ListNode ld = new ListNode(0);
        ListNode cld = ld;
        ListNode gd = new ListNode(0);
        ListNode cgd = gd;
        while (head != null) {
            if (head.val < x) {
                cld.next = new ListNode(head.val);
                cld = cld.next;
            }else{
                cgd.next = new ListNode(head.val);
                cgd = cgd.next;
            }
            head = head.next;
        }
        cld.next = gd.next;
        return ld.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        Medium86 medium86 = new Medium86();
        ListNodeUtil.show(medium86.partition(ListNodeUtil.build(1,4,3,2,6,2), 3));
        ListNodeUtil.show(medium86.partition2(ListNodeUtil.build(1,4,3,2,6,2), 3));

        ListNodeUtil.show(medium86.partition(ListNodeUtil.build(2,1), 2));
        ListNodeUtil.show(medium86.partition2(ListNodeUtil.build(2,1), 2));

    }

}
