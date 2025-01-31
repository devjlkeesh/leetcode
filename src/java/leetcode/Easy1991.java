package leetcode;

public class Easy1991 {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Easy1991 e = new Easy1991();
        System.out.println(e.findMiddleIndex(new int[]{3, 2, -1, 8, 4}));
    }
}
