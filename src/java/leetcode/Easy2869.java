package leetcode;

import java.util.List;

public class Easy2869 {
    public int minOperations(List<Integer> nums, int k) {
        int[] arr = new int[k + 1];
        int mark = 0;
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (mark == k) {
                break;
            }
            int num = nums.get(i);
            if (num <= k && arr[num] == 0) {
                arr[num] = 1;
                mark++;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Easy2869 demo = new Easy2869();
        System.out.println(demo.minOperations(List.of(3,1,5,4,2),2));
        System.out.println(demo.minOperations(List.of(3,1,5,4,2),5));
        System.out.println(demo.minOperations(List.of(3,2,5,3,1),3));
    }
}
