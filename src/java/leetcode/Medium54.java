package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;
        int l = 0;
        for (int[] ints : matrix) {
            l+=ints.length;
        }
        while (list.size() < l) {
            for (int i = left; i <= right && list.size() <= n * m; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && list.size() <= n * m; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && list.size() <= n * m; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && list.size() <= n * m; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        Medium54 medium54 = new Medium54();
        System.out.println(medium54.spiralOrder(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        }));
    }
}
