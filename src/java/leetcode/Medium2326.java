package leetcode;

public class Medium2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int g = 1, top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (g <= m * n) {
            // Left to Right
            for (int i = left; i <= right; i++) {
                int num = head != null ? head.val : -1;
                g++;
                head = head.next;
                matrix[top][i] = num;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                int num = head != null ? head.val : -1;
                g++;
                head = head.next;
                matrix[i][right] = num;
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    int num = head != null ? head.val : -1;
                    g++;
                    head = head.next;
                    matrix[bottom][i] = num;
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    int num = head != null ? head.val : -1;
                    g++;
                    head = head.next;
                    matrix[i][left] = num;
                }
                left++;
            }
        }

        return matrix;
    }
}
