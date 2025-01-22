package easy;

public class Easy3360 {
    public boolean canAliceWin(int n) {
        if (n < 10) {
            return false;
        }
        int prev = 10;
        boolean[] turns = {true, false};
        int i = 0;
        while (n >= prev) {
            n -= prev;
            prev--;
            turns[0] = i % 2 == 0;
            turns[1] = !turns[0];
            i++;
        }
        return turns[0];
    }

    public static void main(String[] args) {
        Easy3360 e = new Easy3360();
        System.out.println(e.canAliceWin(19));
    }
}
