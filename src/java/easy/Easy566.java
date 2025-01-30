package easy;

import java.util.Arrays;

public class Easy566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length * mat[0].length != r * c) {
                return mat;
            }
            int mi = 0;
            int mj = 0;
            int mc = mat[0].length;
            int[][] res = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    res[i][j] = mat[mi][mj++];
                    if (mj >= mc) {
                        mj = 0;
                        mi++;
                    }
                }
            }
            return res;
    }

    public static void main(String[] args) {
        Easy566 test = new Easy566();
        System.out.println(Arrays.deepToString(test.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }
}
