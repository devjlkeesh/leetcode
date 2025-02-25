package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Medium2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }
            int prevIdx = stack.isEmpty() ? -1 : stack.peek();
            leftSum[i] = (prevIdx == -1 ? 0 : leftSum[prevIdx]) + (long) maxHeights.get(i) * (i - prevIdx);
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }
            int nextIdx = stack.isEmpty() ? n : stack.peek();
            rightSum[i] = (nextIdx == n ? 0 : rightSum[nextIdx]) + (long) maxHeights.get(i) * (nextIdx - i);
            stack.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, leftSum[i] + rightSum[i] - maxHeights.get(i));
        }
        return maxSum;
    }
}
