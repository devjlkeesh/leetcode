package leetcode;

public class Easy495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        int prev = 0;
        for (int t : timeSeries) {
            if (t != 0 && prev >= t) {
                total -= prev - t + 1;
            }
            prev = t + duration - 1;
            total += duration;
        }
        return total;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return total + duration;
    }

    public static void main(String[] args) {
        Easy495 test = new Easy495();
        System.out.println(test.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(test.findPoisonedDuration(new int[]{1, 2}, 2));
        System.out.println(test.findPoisonedDuration(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
