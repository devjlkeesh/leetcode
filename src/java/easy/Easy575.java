package easy;

public class Easy575 {
    public int distributeCandies(int[] candyType) {
        boolean[] ct = new boolean[100_000 * 2 + 1];
        int typeCount = 0;
        for (int t : candyType) {
            int index = t + 100_000;
            if (!ct[index]) {
                typeCount++;
                if (typeCount == candyType.length / 2) {
                    return candyType.length / 2;
                }
                ct[index] = true;
            }
        }
        return typeCount;
    }
}
