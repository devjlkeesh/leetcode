package leetcode;

import java.util.Arrays;

public class SpiralMartix {
    public static int[][] generateSpiralMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int num = 1, top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (num <= m * n) {
            // Left to Right
            for (int i = left; i <= right; i++) matrix[top][i] = num++;
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) matrix[i][right] = num++;
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) matrix[bottom][i] = num++;
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) matrix[i][left] = num++;
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateSpiralMatrix(5, 3);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
