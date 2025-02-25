package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Easy225 {
    class MyStack {
        private Deque<Integer> queue;

        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            return queue.pollLast();
        }

        public int top() {
            return queue.peekLast();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
