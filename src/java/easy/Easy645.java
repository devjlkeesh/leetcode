package easy;

import java.util.Arrays;

public class Easy645 {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length + 1];
        int d = 0;
        int total = 0;
        for (int num : nums) {
            if (map[num] == 1){
                d = num;
            }
            map[num]++;
            total += num;
        }
        int neededSum = nums.length * (nums.length+1)/2;
        int missing = total - neededSum + d;
        return new int[]{d, missing};
    }

    public static void main(String[] args) {
        Easy645 test = new Easy645();
        System.out.println(Arrays.toString(test.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(test.findErrorNums(new int[]{1, 2,2,4})));
    }
}
