package leetcode;

import java.util.Arrays;

public class Easy1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        if (n == 1) return prices;
        for (int i = 0; i < n; i++) prices[i] = prices[i] - getDiscount(prices, i);
        return prices;
    }

    private static int getDiscount(int[] prices, int i) {
        for (int j = i + 1; j < prices.length; j++)
            if (prices[i] >= prices[j]) return prices[j];
        return 0;
    }

    public static void main(String[] args) {
        Easy1475 demo = new Easy1475();
        System.out.println(Arrays.toString(demo.finalPrices(new int[]{8, 4, 6, 2, 3})));
    }
}
