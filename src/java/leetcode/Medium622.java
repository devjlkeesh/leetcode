package leetcode;

import java.util.Arrays;

public class Medium622 {
    public static class MyCircularQueue {
        public final Integer[] queue;
        private int capacity;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            this.queue = new Integer[k];
            this.capacity = k;
            this.front = 0;
            this.rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (front == rear) {
                front = -1;
                rear = -1;
                return true;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[rear];
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(Arrays.toString(myCircularQueue.queue));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(Arrays.toString(myCircularQueue.queue));
        System.out.println("da");
        myCircularQueue = new MyCircularQueue(8);
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(9));
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.enQueue(0));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println("asdas");
        myCircularQueue = new MyCircularQueue(2);
        //["MyCircularQueue","enQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue", "Front"]
        // [[2],[1],[2],[],[3],[],[3],[],[3],[],[]]
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.deQueue());

        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());

        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());

        System.out.println(myCircularQueue.Front());

    }
}
