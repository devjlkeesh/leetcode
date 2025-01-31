package leetcode;

public class Easy1025 {
    public boolean divisorGame(int n) {
        // x with 0 < x < n and n % x == 0.
/*        if (n == 1) {
            return false;
        }
        boolean aliceTurn = false;
        while (n > 1) {
            n--;
            aliceTurn = !aliceTurn;
        }*/
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Easy1025 obj = new Easy1025();
        System.out.println(obj.divisorGame(2));
        System.out.println(obj.divisorGame(3));
        System.out.println(obj.divisorGame(4));
    }
}
