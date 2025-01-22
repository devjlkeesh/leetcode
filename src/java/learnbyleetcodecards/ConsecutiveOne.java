package learnbyleetcodecards;

public class ConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        //1,1,0,1,1,1
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return  Math.max(max, count);
    }
}
