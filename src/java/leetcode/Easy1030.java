package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Easy1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] coords = new int[rows * cols][3];
        for (int i = 0; i < rows; i++) {
            int rDistance = Math.abs(i - rCenter);
            for (int j = 0; j < cols; j++) {
                coords[i * cols + j] = new int[]{rDistance + Math.abs(j - cCenter), i, j};
            }
        }
        Arrays.sort(coords, Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[coords.length][2];
        for (int i = 0; i < coords.length; i++) {
            result[i] = new int[]{coords[i][1], coords[i][2]};
        }
        return result;
    }

    public static void main(String[] args) {
        Easy1030 obj = new Easy1030();
        int[][] coords = obj.allCellsDistOrder(2, 2, 0, 1);
        System.out.println(Arrays.deepToString(coords));
    }
}
