package easy;

public class Easy1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] pair : indices) {
            int rowi = pair[0];
            int coli = pair[1];
            rows[rowi]++;
            cols[coli]++;
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Easy1252 solution = new Easy1252();
        System.out.println(solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
