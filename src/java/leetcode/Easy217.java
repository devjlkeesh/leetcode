package leetcode;

public class Easy217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Easy217 solution = new Easy217();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
