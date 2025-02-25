package leetcode;

public class Easy706 {
    public static class MyHashMap {
        private Node[] table;

        public MyHashMap() {
            table = new Node[10000];
        }

        public void put(int key, int value) {
            int keyIndex = index(key);
            Node node = table[keyIndex];
            if (node == null) {
                table[keyIndex] = new Node(key, value);
                return;
            }
            Node prev = null;
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
        }

        public int get(int key) {
            Node node = table[index(key)];
            if (node == null) {
                return -1;
            }
            while (node != null) {
                if (node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
            return -1;
        }

        public void remove(int key) {
            int keyIndex = index(key);
            Node node = table[keyIndex];
            if (node == null) return;
            if (node.key == key) table[keyIndex] = node.next;
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        private int index(int key) {
            return key % 10000;
        }


        static class Node {
            int key, val;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new Easy706.MyHashMap();
        //["MyHashMap","put","put","get","get","put","get","remove","get"]
//        [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        //[null,null,null,1,-1,null,1,null,-1]
        System.out.println(myHashMap.get(2));
    }
}
