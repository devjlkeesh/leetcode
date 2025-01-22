package learnbyleetcodecards;


class ConsecutiveOneTest {

    static void findMaxConsecutiveOnes() {
        ConsecutiveOne consecutiveOne = new ConsecutiveOne();
        int maxConsecutiveOnes = consecutiveOne.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }

    public static void main(String[] args) {
        findMaxConsecutiveOnes();
    }
}