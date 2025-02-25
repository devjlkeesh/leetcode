package leetcode;

import java.util.Arrays;

public class Easy2903 {
    /*
    abs(i - j) >= indexDifference, and
    abs(nums[i] - nums[j]) >= valueDifference
     */
    /*
    Example 1:

Input: nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
Output: [0,3]
Explanation: In this example, i = 0 and j = 3 can be selected.
abs(0 - 3) >= 2 and abs(nums[0] - nums[3]) >= 4.
Hence, a valid answer is [0,3].
[3,0] is also a valid answer.
Example 2:

Input: nums = [2,1], indexDifference = 0, valueDifference = 0
Output: [0,0]
Explanation: In this example, i = 0 and j = 0 can be selected.
abs(0 - 0) >= 0 and abs(nums[0] - nums[0]) >= 0.
Hence, a valid answer is [0,0].
Other valid answers are [0,1], [1,0], and [1,1].
Example 3:

Input: nums = [1,2,3], indexDifference = 2, valueDifference = 4
Output: [-1,-1]
Explanation: In this example, it can be shown that it is impossible to find two indices that satisfy both conditions.
Hence, [-1,-1] is returned.
    */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i-j)>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Easy2903 demo = new Easy2903();
        System.out.println(Arrays.toString(demo.findIndices(new int[]{5,1,4,1}, 2, 4)));
        System.out.println(Arrays.toString(demo.findIndices(new int[]{1,2,3}, 2, 4)));
        System.out.println(Arrays.toString(demo.findIndices(new int[]{2,1}, 0, 0)));
    }
}
