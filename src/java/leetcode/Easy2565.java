package leetcode;

public class Easy2565 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int neededSum = n * n * (n * n + 1) / 2;
        int actualSum = 0;
        int[] map = new int[n * n + 1];
        int dublicate = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (map[cell] != 0) {
                    dublicate = cell;
                } else {
                    map[cell]++;
                }
                actualSum += cell;
            }
        }
        return new int[]{dublicate, neededSum + dublicate - actualSum};
    }
}
