package leetcode;

import java.util.Arrays;

public class Easy867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transpose = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        Easy867 demo = new Easy867();
        System.out.println(Arrays.deepToString(demo.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }
}
