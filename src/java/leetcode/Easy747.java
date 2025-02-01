package leetcode;

public class Easy747 {

    public int dominantIndex(int[] nums) {
        int[] m = new int[101];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }
            if (num > max2 && num < max1) {
                max2 = num;
            }
            m[num]++;
        }
        if (max1 < max2 * 2) {
            return -1;
        }
        return m[max1];
    }

    public static void main(String[] args) {
        Easy747 demo = new Easy747();
        System.out.println(demo.dominantIndex(new int[]{1, 2, 3, 4, 5}));
        System.out.println(demo.dominantIndex(new int[]{3,6,1,0}));
    }

}
