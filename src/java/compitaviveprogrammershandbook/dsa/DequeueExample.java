package compitaviveprogrammershandbook.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeueExample {
    public static void main(String[] args) {
        Deque<String> dequeue = new ArrayDeque<>();
        dequeue.add("Java");
        dequeue.add("Python");
        dequeue.add("C#");
        dequeue.add("C++");
        dequeue.add("Rust");
        dequeue.add("C");
        int i = dequeue.size();
        while (i > 0){
            System.out.println("dequeue.getFirst() = " + dequeue.pollLast());
            System.out.println("dequeue.getFirst() = " + dequeue.pollFirst());
            i--;
        }
        System.out.println("dequeue = " + dequeue.size());
    }
}
