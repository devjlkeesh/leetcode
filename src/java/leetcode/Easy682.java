package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Easy682 {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String operation : operations) {
            char i = operation.charAt(0);
            switch (i) {
                case '+' -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b);
                    stack.push(a);
                    stack.push(a + b);
                }
                case 'D' -> {
                    Integer a = stack.peek();
                    stack.push(a * 2);
                }
                case 'C' -> stack.pop();
                default -> stack.push(Integer.valueOf(operation));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public int calPoints2(String[] operations) {
        int[] m = new int[operations.length];
        int j = 0;
        for (String operation : operations) {
            char i = operation.charAt(0);
            switch (i) {
                case '+' -> {
                    int a = m[j - 1];
                    int b = m[j - 2];
                    m[j++] = a + b;
                }
                case 'D' -> {
                    m[j] = m[j - 1] * 2;
                    j++;
                }

                case 'C' -> j--;
                default -> m[j++] = Integer.parseInt(operation);
            }
        }
        int sum = 0;
        for (int i = 0; i < j; i++) {
            sum += m[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Easy682 solution = new Easy682();
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D"}));
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(solution.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

        System.out.println(solution.calPoints2(new String[]{"5", "2", "C", "D"}));
        System.out.println(solution.calPoints2(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(solution.calPoints2(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

    }
}
