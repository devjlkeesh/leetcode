package medium;

import java.util.Arrays;

public class Middle945 {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        Arrays.sort(nums);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                index = i;
                break;
            }
        }
        if (index == 0){
            return 0;
        }
        if (nums.length - index <= 1) {
            return nums.length - index;
        }
        int increment = 1;
        //[3,2,1,2,1,7]
        int prev = nums[index - 1];
        for (int i = index; i < nums.length; i++) {
            int x = prev + 1 - nums[i];
            increment += x;
            prev = nums[i] + x;
        }
        return increment;
    }

    public static void main(String[] args) {
        Middle945 m = new Middle945();
        System.out.println(m.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
        System.out.println(m.minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(m.minIncrementForUnique(new int[]{1,0}));
    }
}
