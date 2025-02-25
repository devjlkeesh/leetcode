package leetcode;

public class Medium707 {
    class MyLinkedList {
        private Node head;
        private Node tail;
        private int size;

        public MyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val, head);
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size || index < 0) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
                prev.next = new Node(val, prev.next);
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
                if (size == 1) {
                    tail = null;
                }
            } else {
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
                prev.next = prev.next.next;
                if (index == size - 1) {
                    tail = prev;
                }
            }
            size--;
        }

        static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
