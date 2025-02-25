package leetcode;

public class Easy1128 {
    public int numEquivDominoPairs(int[][] dominoes)  {
        int res = 0;
        for (int i = 0; i < dominoes.length - 1; i++) {
            int[] p1 = dominoes[i];
            for (int j = i + 1; j < dominoes.length; j++) {
                int[] p2 = dominoes[j];
                if (p1[0] * p1[1] == p2[0] * p2[1]) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int res = 0;
        for (int i = 0; i < dominoes.length - 1; i++) {
            int[] p1 = dominoes[i];
            for (int j = i + 1; j < dominoes.length; j++) {
                int[] p2 = dominoes[j];
                if (p1[0]  == p2[0] && p1[1] == p2[1] || p1[0]  == p2[1] && p1[1] == p2[0]) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy1128 demo = new Easy1128();
        System.out.println(demo.numEquivDominoPairs(new int[][]{{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}}));
        System.out.println(demo.numEquivDominoPairs2(new int[][]{{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}}));
    }

}
