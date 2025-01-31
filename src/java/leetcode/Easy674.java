package leetcode;

public class Easy674 {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1   ;
            }
            prev = nums[i];
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        Easy674 obj = new Easy674();
        System.out.println(obj.findLengthOfLCIS(new int[]{1, 2, 3, 5, 4, 6, 7, 9}));
        System.out.println(obj.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(obj.findLengthOfLCIS(new int[]{1,3,5,4,2,3,4,5}));
    }
}
