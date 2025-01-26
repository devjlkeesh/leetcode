package easy;

public class Easy3222 {
    public String winningPlayer(int x, int y) {
        boolean aliceTurn = true;
        while (x * 75 + y * 10 >= 115) {
            if (x > 0) {
                x--;
            }
            if (y > 4) {
                y -= 4;
            }
            aliceTurn = !aliceTurn;
        }
        return aliceTurn ? "Alice" : "Bob";
    }
}
