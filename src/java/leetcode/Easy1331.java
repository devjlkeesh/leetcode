package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Easy1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[][] arr2 = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = new int[] { arr[i],i };
        }
        Arrays.sort(arr2, Comparator.comparingInt(a -> a[0]));
        int rank = 1;
        arr[arr2[0][1]] = rank;
        for (int i = 1; i < arr.length; i++) {
            if (arr2[i][0] != arr2[i - 1][1]) {
                rank++;
            }
            arr[arr2[i][1]] = rank;
        }
        return arr;
    }
}
