package leetcode;

public class Medium2342 {
    public int maximumSum(int[] nums) {
        int[] map = new int[82];
        int max = -1;
        int s;
        int dc;
        for (int num : nums) {
            s = num;
            dc = 0;
            while (s > 0) {
                dc += s % 10;
                s /= 10;
            }
            if (map[dc] != 0) max = Math.max(max, map[dc] + num);
            map[dc] = Math.max(map[dc], num);
        }
        return max;
    }

    public static void main(String[] args) {
        Medium2342 medium2342 = new Medium2342();
        System.out.println(medium2342.maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(medium2342.maximumSum(new int[]{368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183}));
    }
}
