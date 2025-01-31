package leetcode;

public class Easy1539 {

    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int prev = 0;
        for (int num : arr) {
            missingCount += num - prev - 1;
            if (missingCount == k) {
                return num - 1;
            } else if (missingCount > k) {
                return num - (missingCount - k) - 1;
            }
            prev = num;
        }
        return arr[arr.length - 1] + (k - missingCount);
    }

}
