package leetcode;

import java.util.Arrays;

public class Easy506 {
    public String[] findRelativeRanks(int[] score) {
        int[][] p = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            p[i] = new int[]{score[i], i};
        }
        Arrays.sort(p, (o1, o2) -> Integer.compare(o2[0], o1[0]));
        String[] ans = new String[score.length];
        int j = 1;
        for (int[] n : p) {
            switch (j) {
                case 1 -> ans[n[1]] = "Gold Medal";
                case 2 -> ans[n[1]] = "Silver Medal";
                case 3 -> ans[n[1]] = "Bronze Medal";
                default -> ans[n[1]] = String.valueOf(j);
            }
            j++;
        }
        return ans;
    }
    public String[] findRelativeRanks2(int[] score) {
        int max = Integer.MIN_VALUE;
        for (int k : score) {
            max = Math.max(max, k);
        }
        int[] p = new int[max+1];
        for (int i = 0; i < score.length; i++) {
            p[score[i]] = i+1;
        }
        String[] ans = new String[score.length];
        int rank = 1;
        for (int i = max; i >= 0; i--) {
            if (p[i] != 0) {
                int id=p[i]-1;
                switch (rank){
                    case 1 -> ans[id] = "Gold Medal";
                    case 2 -> ans[id] = "Silver Medal";
                    case 3 -> ans[id] = "Bronze Medal";
                    default -> ans[id] = String.valueOf(rank);
                }
                rank++;
                if (rank > score.length ) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Easy506 obj = new Easy506();
        System.out.println(Arrays.toString(obj.findRelativeRanks(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(obj.findRelativeRanks(new int[]{10,3,8,9,4})));
        System.out.println(Arrays.toString(obj.findRelativeRanks2(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(obj.findRelativeRanks2(new int[]{10,3,8,9,4})));
    }
}
