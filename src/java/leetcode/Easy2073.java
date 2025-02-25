package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Easy2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new int[]{i, tickets[i]});
        }
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            time++;
            if (person[1] > 1) {
                person[1]--;
                queue.add(person);
            } else if (person[0] == k) {
                break;
            }
        }
        return time;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) time += Math.min(tickets[i], tickets[k]);
            else time += Math.min(tickets[i], tickets[k] - 1);
        }
        return time;
    }

    public static void main(String[] args) {
        Easy2073 test = new Easy2073();
        System.out.println(test.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(test.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(test.timeRequiredToBuy2(new int[]{2, 3, 2}, 2));
        System.out.println(test.timeRequiredToBuy2(new int[]{5, 1, 1, 1}, 0));
    }
}
