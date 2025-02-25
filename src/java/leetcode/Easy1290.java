package leetcode;

public class Easy1290 {
    /*
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.
    */
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
    public int getDecimalValue2(ListNode head) {
            int[] arr = new int[30];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }
        int p = 0;
        i--;
        int decimal = 0;
        while (i >=0){
            decimal += (int) (arr[i--] * Math.pow(2, p++));
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(new Easy1290().getDecimalValue(ListNodeUtil.build(1,0,1)));
        System.out.println(new Easy1290().getDecimalValue(ListNodeUtil.build(1,1)));
        System.out.println(new Easy1290().getDecimalValue(ListNodeUtil.build(1,0,1,0)));
        System.out.println(new Easy1290().getDecimalValue(ListNodeUtil.build(1,0,1,1)));
        System.out.println(new Easy1290().getDecimalValue(ListNodeUtil.build(0)));
    }
}
