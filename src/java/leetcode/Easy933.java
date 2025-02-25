package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    private int[] arr;
    private int i;
    private int j;

    public RecentCounter() {
        this.arr = new int[100];
        this.i = 0;
        this.j = 0;
    }

    public int ping(int t) {
        while (i < j && t - arr[i] > 3000) {
            i++;
        }
        arr[j++] = t;
        return j - i;
    }
}

public class Easy933 {

}
