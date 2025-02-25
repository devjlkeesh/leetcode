package leetcode;

import java.util.StringJoiner;

public class Medium641 {
    public static class MyCircularDeque {
        private ListNode head;
        private ListNode tail;
        private int size;
        private final int length;

        public MyCircularDeque(int k) {
            this.length = k;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if (size == length) return false;
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size == length) return false;
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) return false;
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                head =tail = null;
            }else{
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return true;
        }

        public int getFront() {
            return size != 0 ? head.val : -1;
        }

        public int getRear() {
            return size != 0 ? tail.val : -1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == length;
        }

        public static class ListNode {
            int val;
            ListNode next, prev;

            ListNode(int x) {
                val = x;
            }
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(" ", "[", "]");
            ListNode cur = this.head;
            while (cur != null) {
                sj.add(cur.val + "");
                cur = cur.next;
            }
            return sj.toString();
        }
    }

    public static void main(String[] args) {
        MyCircularDeque q = new MyCircularDeque(10);
        q.insertLast(12);
        q.insertFront(1);
        q.insertFront(2);
        q.insertFront(3);
        System.out.println(q);
        q.insertLast(4);
        System.out.println(q);
        q.deleteFront();
        q.deleteFront();
        System.out.println(q);
        q.deleteLast();
        q.deleteLast();
        System.out.println(q);
    }
}
