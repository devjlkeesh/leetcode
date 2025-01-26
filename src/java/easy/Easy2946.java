package easy;

public class Easy2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k %= m;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int newIndex = i % 2 == 0 ? (j + k) % m : (j - k + m) % m;
                if (mat[newIndex][j] != mat[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Easy2946 solution = new Easy2946();
        solution.areSimilar(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 4);
    }
}
