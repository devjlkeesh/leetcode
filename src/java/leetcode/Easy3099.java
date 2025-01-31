package leetcode;

public class Easy3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int c = x;
        while (c > 0) {
            sum += c % 10;
            c /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
