package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Easy1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1){
            return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int max1 = pq.poll();
            int max2 = pq.poll();
            int diff = Math.abs(max1 - max2);
            if (diff > 0) {
                pq.add(diff);
            }
        }
        if (pq.size() == 1) {
            return pq.poll();
        }
        return 0;
    }
    public int lastStoneWeight2(int[] stones) {
        if (stones.length == 1){
            return 1;
        }
        int n = stones.length;
        while (n>1){
            Arrays.sort(stones);
            int m1 = stones[n-1];
            int m2 = stones[n-2];
            int diff = Math.abs(m1 - m2);
            if (diff == 0) {
                n-=2;
            }else{
                stones[n-2] = diff;
                n--;
            }
        }
        if (n == 1){
            return stones[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        Easy1046 demo = new Easy1046();
        System.out.println(demo.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(demo.lastStoneWeight(new int[]{1}));
        System.out.println(demo.lastStoneWeight2(new int[]{2,7,4,1,8,1}));
        System.out.println(demo.lastStoneWeight2(new int[]{1}));
    }
}
