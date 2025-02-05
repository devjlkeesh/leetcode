package leetcode;

public class Easy961 {
    public int repeatedNTimes(int[] nums) {
        int[] m = new int[10_001];
        for (int num : nums) {
            if (m[num] != 0) {
                return num;
            }
            m[num] = num + 1;
        }
        return -1;
    }
}
