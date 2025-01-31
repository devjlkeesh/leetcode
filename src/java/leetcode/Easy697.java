package leetcode;

import java.util.HashMap;

public class Easy697 {

    public int findShortestSubArray(int[] nums) {
        /*
        Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
        Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] m  = new int[50000];
        for (int num : nums) {
            m[num]++;
        }
        int degree = Integer.MIN_VALUE;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > degree) {
                degree = i;
            }
        }

    return m[degree];
    }

}
