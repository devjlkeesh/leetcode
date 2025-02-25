package learnbyleetcodecards.linkedlist;

class MyLinkedList {
    private Node head, tail;
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
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        Node newNode = new Node(val);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
        } else {
            Node current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        size--;
    }

    static class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        // [[],[1],[3],[1,2],[1],[1],[1]]
//        MyLinkedList ml = new MyLinkedList();
//        ml.addAtHead(1);
//        ml.addAtHead(3);
//        ml.addAtHead(6);
//        ml.addAtHead(9);
//        System.out.println(ml);
//        ml.addAtTail(5);
//        ml.addAtTail(15);
//        ml.addAtTail(25);
//        ml.addAtIndex(0, 123);
//        System.out.println(ml);
//        ml.addAtIndex(3, 13);
//        System.out.println(ml);
//        ml.deleteAtIndex(3);
//        System.out.println(ml);

        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        System.out.println(obj);
        System.out.println(obj.get(1)); // Expected output: 2
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1)); // Expected output: 3
    }

}
