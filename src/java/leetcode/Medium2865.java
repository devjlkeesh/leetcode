package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Medium2865 {

    public long maximumSumOfHeights(int[] heights) {
        long max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            long sum = min;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < min) min = heights[j];
                sum += min;
            }
            min = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < min) min = heights[j];
                sum += min;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public long maximumSumOfHeights2(int[] heights) {
        int n = heights.length;
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            int prevIdx = stack.isEmpty() ? -1 : stack.peek();
            leftSum[i] = (prevIdx == -1 ? 0 : leftSum[prevIdx]) + (long) heights[i] * (i - prevIdx);
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            int nextIdx = stack.isEmpty() ? n : stack.peek();
            rightSum[i] = (nextIdx == n ? 0 : rightSum[nextIdx]) + (long) heights[i] * (nextIdx - i);
            stack.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, leftSum[i] + rightSum[i] - heights[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Medium2865 m = new Medium2865();
        System.out.println(m.maximumSumOfHeights(new int[]{5, 3, 4, 1, 1}));
        System.out.println(m.maximumSumOfHeights(new int[]{6, 5, 3, 9, 2, 7}));
        System.out.println(m.maximumSumOfHeights(new int[]{1000000000, 1000000000, 1000000000}));
        System.out.println(m.maximumSumOfHeights(new int[]{1, 2, 2, 2, 6, 1, 4, 6, 4}));
    }

}
