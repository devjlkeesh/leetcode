package leetcode;

public class Easy1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] map = new int[10];
        for (int num : arr1) {
            map[num]++;
        }
        int ind = 0;
        for (int num : arr2) {
            int a = map[num];
            if (a > 0) {
                for (int i = 0; i < a; i++) {
                    ans[ind++] = num;
                }
                map[num] = 0;
            }
        }
        for (int i = 0; i < 10; i++) {
            int a = map[i];
            if (a > 0) {
                for (int j = 0; j < a; j++) {
                    ans[ind++] = i;
                }
            }
        }
        return ans;
    }
}
