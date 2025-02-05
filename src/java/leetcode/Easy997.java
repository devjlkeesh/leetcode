package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy997 {
    public int findJudge(int n, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return -1;
        }
        int[] m = new int[n + 1];
        int[] s = new int[n + 1];
        for (int[] p : trust) {
            m[p[1]]++;
            s[p[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if(m[i] == n-1 && s[i] == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Easy997 demo = new Easy997();
        System.out.println(demo.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(demo.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        System.out.println(demo.findJudge(3, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
