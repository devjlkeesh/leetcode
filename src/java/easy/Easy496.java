package easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Easy496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            int id = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    id = j;
                    break;
                }
            }
            for (int j = id; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num: nums2){
            while (!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Easy496 obj = new Easy496();
        //[4,1,2], nums2 = [1,3,4,2]
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{1,3,5,2,4},new int[]{5,4,3,2,1})));
        System.out.println(Arrays.toString(obj.nextGreaterElement2(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(obj.nextGreaterElement2(new int[]{1,3,5,2,4},new int[]{5,4,3,2,1})));
    }
}
