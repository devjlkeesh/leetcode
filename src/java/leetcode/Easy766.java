package leetcode;

public class Easy766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        for (int c = 0; c < n; c++) {
            i=0;
            j = c;
            int prev = matrix[i][j];
            while (i < m && j < n) {
                if (prev != matrix[i++][j++]) {
                    return false;
                }
            }
        }
        for (int c = 0; c < m; c++) {
            i = c;
            j = 0;
            int prev = matrix[i][j];
            while (i < m && j < n) {
                if (prev != matrix[i++][j++]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy766 demo = new Easy766();
        System.out.println(demo.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }
}
