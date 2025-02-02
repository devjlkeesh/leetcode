package leetcode;

public class Medium2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (head != null) {
                    res[i][j] = head.val;
                    head = head.next;
                }else{
                    res[i][j] = -1;
                }
            }
        }
        return res;
    }
}
