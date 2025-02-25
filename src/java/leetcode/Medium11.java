package leetcode;

public class Medium11 {
    public int maxArea(int[] height) {
        int a = height[0];
        int b = height[height.length - 1];
        int max = Math.min(a, b) * (b - a);
        while (a < b) {
            int area = Math.min(height[a], height[b]) * (b - a);
            max = Math.max(max, area);
            if (height[a] < height[b]) {
                a++;
            } else {
                b++;
            }
        }
        return max;
    }
}
