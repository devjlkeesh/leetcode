package leetcode;

public class Medium59 {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int num = 1;
        int[][] matrix = new int[n][n];
        int l = n * n;
        while (num <= l) {
            for (int i = left; i <= right && num <= l; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom && num <= l; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left && num <= l; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num <= l; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
