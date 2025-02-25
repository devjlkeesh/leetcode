package leetcode;

import java.util.HashMap;

public class Medium138 {
    public static  class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    private HashMap<Node,Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node newNode = new Node(head.val);
        map.put(head, newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

    public static void main(String[] args) {
        Medium138 m = new Medium138();
        // [[3,null],[3,0],[3,null]]
        Node node3 = new Node(3);
        Node node2 = new Node(3);
        node2.next = node3;
        node2.random = new Node(0);
        Node node = new Node(3);
        node.next = node2;
        show(node);
        var nnode = m.copyRandomList(node);
        show(nnode);
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        show(node);
        nnode = m.copyRandomList(node);
        show(nnode);
    }

    public static void show(Node head) {
        Node cur = head;
        if (cur == null) {
            return;
        }
        while (cur != null) {
            var nr = cur.random;
            System.out.print(cur.val + " ");
            if (nr != null) {
                show(nr);
            }
            cur = cur.next;
        }
        System.out.println();
    }

}
