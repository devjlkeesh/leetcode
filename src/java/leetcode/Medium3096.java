package leetcode;

import java.util.PriorityQueue;

public class Medium3096 {
    public int minOperations(int[] nums, int k) {

        int count = 0;
        int[] dp = new int[nums.length];
        int id = 0;
        for (int num : nums) {
            if (num <= k) {
                dp[id++] = num;
            }
        }
        int n = id;
        while (n > 1) {
            int min1Index = 0;
            int min1 = Integer.MAX_VALUE;
            int min2Index = 0;
            int min2 = Integer.MAX_VALUE;
            boolean allHigher = true;
            for (int i = 0; i < id; i++) {
                if (dp[i] != 0) {
                    if (dp[i] < min1) {
                        int ti = min1Index;
                        int t = min1;
                        min1Index = i;
                        min1 = dp[i];
                        min2Index = ti;
                        min2 = t;
                    } else if (dp[i] < min2 && min1Index != i) {
                        min2Index = i;
                        min2 = dp[i];
                    }
                    if (dp[i] < k) {
                        allHigher = false;
                    }
                }
            }
//            System.out.println(min1 + " " + min2);
            if (allHigher || min1 == Integer.MAX_VALUE && min2 == Integer.MAX_VALUE) {
                break;
            }
            long num = Math.min(min1, min2) * 2L + Math.max(min1, min2);
            if (num >= Integer.MAX_VALUE) {
                dp[min1Index] = 0;
            } else {
                dp[min1Index] = (int) num;
            }
            dp[min2Index] = 0;
            count++;
            n--;
        }
        return count;
    }

    public int minOperations2(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num <= k) {
                pq.add(num);
            }
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a >= k && b >= k) {
                break;
            }
            long num = a * 2L + b;
            if (num < Integer.MAX_VALUE) {
                pq.add((int) num);
            }else{
                pq.add(Integer.MAX_VALUE);
            }
            count++;
        }
        return count;
    }
    public int minOperations3(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num <= k) pq.add(num);
        }
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (a >= k) break;
            count++;
            if ( pq.isEmpty()) break;
            int b = pq.poll();
            long num = a * 2L + b;
            if (num < k) pq.add((int) num);
        }
        return count;
    }

    public static void main(String[] args) {
        Medium3096 m = new Medium3096();
        System.out.println(m.minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(m.minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(m.minOperations(new int[]{19, 44, 61, 96, 84, 79, 84, 61, 97, 44}, 44));
        System.out.println(m.minOperations(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
        System.out.println("as");
        System.out.println(m.minOperations2(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(m.minOperations2(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(m.minOperations2(new int[]{19, 44, 61, 96, 84, 79, 84, 61, 97, 44}, 44));
        System.out.println(m.minOperations2(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
        System.out.println(m.minOperations2(new int[]{999999999,999999999,999999999}, 1000000000));
        System.out.println("as");
        System.out.println(m.minOperations3(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(m.minOperations3(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(m.minOperations3(new int[]{19, 44, 61, 96, 84, 79, 84, 61, 97, 44}, 44));
        System.out.println(m.minOperations3(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000));
        System.out.println(m.minOperations3(new int[]{999999999,999999999,999999999}, 1000000000));

    }
}
