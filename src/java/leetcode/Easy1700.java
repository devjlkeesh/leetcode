package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Easy1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichStack = new Stack<>();
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
        for (int student : students) {
            studentQueue.add(student);
        }
        int len = studentQueue.size();
        int count = 0;
        while (!studentQueue.isEmpty() && count < len * len) {
            Integer student = studentQueue.poll();
            if (student.equals(sandwichStack.peek())) {
                sandwichStack.pop();
            } else {
                studentQueue.offer(student);
            }
            count++;
        }
        return studentQueue.size();
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }
        int i = 0, failedAttempts = 0;
        while (!studentQueue.isEmpty()) {
            if (studentQueue.peek() == sandwiches[i]) {
                studentQueue.poll();
                i++;
                failedAttempts = 0;
            } else {
                studentQueue.offer(studentQueue.poll());
                failedAttempts++;
            }

            if (failedAttempts == studentQueue.size()) {
                return studentQueue.size();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Easy1700 demo = new Easy1700();
        System.out.println(demo.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(demo.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));

        System.out.println(demo.countStudents2(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(demo.countStudents2(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));

    }
}
