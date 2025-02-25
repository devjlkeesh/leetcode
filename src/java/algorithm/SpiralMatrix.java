package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        int num = 1;
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;
        while (num <= n * m){
            for (int i = left; i <= right && num <= n * m; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom && num <= n * m; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left && num <= n * m; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num <= n * m; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
