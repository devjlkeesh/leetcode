package leetcode;

import java.util.List;

public class Easy3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        // commands consists only of "UP", "RIGHT", "DOWN", and "LEFT"
        /*int[][] matrix = new int[n][n];
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = l++;
            }
        }*/
        int cr = 0;
        int cc = 0;
        for (String command : commands) {
            if (command.charAt(0) == 'U') {
                cr--;
            } else if (command.charAt(0) == 'D') {
                cr++;
            } else if (command.charAt(0) == 'L') {
                cc--;
            } else {
                cc++;
            }
        }
        return (cr*n) + cc;
    }
}
