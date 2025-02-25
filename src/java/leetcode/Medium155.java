package leetcode;

import java.util.Stack;

class MinStack {
    private int[] stack;
    private int[] minStack;
    private int min;
    private int i;
    private int j;

    public MinStack() {
        this.stack = new int[30_000];
        this.minStack = new int[30_000];
        this.i = 0;
        this.j = 0;
    }

    public void push(int val) {
        if (j == 0 || val <= minStack[j - 1]) {
            minStack[j++] = val;
        }
        stack[i++] = val;
    }

    public void pop() {
        int val = stack[--i];
        if (val == minStack[j - 1]) {
            j--;
        }
    }

    public int top() {
        return stack[i - 1];
    }

    public int getMin() {
        return minStack[j - 1];
    }
}

class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Medium155 {
}
