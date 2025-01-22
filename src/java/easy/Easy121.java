package easy;

public class Easy121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            } else {
                profit = Math.max(profit, price - min);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        var s = new Easy121();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
