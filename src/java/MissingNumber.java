import java.util.Scanner;

public class MissingNumber {
    static int solve(long n, int[] arr) {
        long actual = 0;
        for (int num : arr) {
            actual += num;
        }
        long mustBe = n * (1 + n) / 2;
        return (int)(mustBe - actual);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(n, arr));
    }
}
