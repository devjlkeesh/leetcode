package leetcode;

import java.util.Stack;

public class Easy232 {
    class MyQueue {
        private Stack<Integer> stack;
        public MyQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            Integer i = stack.removeFirst();
            return i;
        }

        public int peek() {
            return stack.firstElement();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
