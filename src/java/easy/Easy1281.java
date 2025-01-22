package easy;

public class Easy1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum+=digit;
            n /= 10;
        }
        return Math.abs(product - sum);
    }

    public static void main(String[] args) {
        Easy1281 e = new Easy1281();
        System.out.println(e.subtractProductAndSum(3));
        System.out.println(e.subtractProductAndSum(234));
    }
}
