package leetcode;

public class Easy705 {
   public static class MyHashSet {
        private Node[] table;

        public MyHashSet() {
            this.table = new Node[10000];
        }

        public void add(int key) {
            int keyIndex = index(key);
            Node node = table[keyIndex];
            if (node == null) {
                table[keyIndex] = new Node(key);
                return;
            }
            Node prev = null;
            while (node != null) {
                if (node.key == key) {
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key);
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

        public boolean contains(int key) {
            Node node = table[index(key)];
            if (node == null) return false;
            while (node != null) {
                if (node.key == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        private int index(int key) {
            return key % 10000;
        }

        static class Node {
            int key;
            Node next;

            public Node(int key) {
                this.key = key;
            }
        }
    }

    public static void main(String[] args) {
        Easy705 demo = new Easy705();
        MyHashSet myHashSet = new MyHashSet();
        // ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
        // [[],[1],[2],[1],[3],[2],[2],[2],[2]]
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

}
