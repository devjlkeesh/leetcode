package easy;

public class Easy922 {
    public int[] sortArrayByParityII(int[] nums) {
        int[] even = new int[nums.length / 2];
        int[] odd = new int[nums.length / 2];
        int i = 0, j = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even[i++] = num;
            } else {
                odd[j++] = num;
            }
        }
        boolean a = true;
        for (i = 0; i < nums.length; i++) {
            if (i%2 == 0){
                nums[i] = even[i/2];
            }else{
                nums[i] = odd[i/2];
            }
        }
        return nums;
    }
}
