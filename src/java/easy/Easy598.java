package easy;

// https://leetcode.com/problems/range-addition-ii/description/
public class Easy598 {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return n * m;
        }
        int maxc = Integer.MAX_VALUE;
        int maxr = Integer.MAX_VALUE;
        for (int[] op : ops) {
            if (op[0] < maxr) {
                maxr = op[0];
            }
            if (op[1] < maxc) {
                maxc = op[1];
            }
        }
        return maxr * maxc;
    }
}
