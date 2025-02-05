package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Easy888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int as = 0, bs = 0;
        for (int aliceSize : aliceSizes) {
            as += aliceSize;
        }
        for (int bobSize : bobSizes) {
            bs += bobSize;
        }
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int mustBe = (as + bs) / 2;

        int i = 0, j = 0;
        while (i < aliceSizes.length && j < bobSizes.length) {
            if (as - aliceSizes[i] + bobSizes[j] == mustBe || bs - bobSizes[j] + aliceSizes[i] == mustBe) {
                return new int[]{aliceSizes[i], bobSizes[j]};
            }
            if (as - aliceSizes[i] + bobSizes[j] > mustBe) {
                i++;
            } else if (as - aliceSizes[i] + bobSizes[j] < mustBe) {
                j++;
            }
            if (bs - bobSizes[j] + aliceSizes[i] > mustBe) {
                j++;
            } else if ((bs - bobSizes[j] + aliceSizes[i] < mustBe)){
                i++;
            }
        }
        return new int[]{0,0};
    }

    public int[] fairCandySwap2(int[] aliceSizes, int[] bobSizes) {
        int as = 0, bs = 0;
        for (int aliceSize : aliceSizes) {
            as += aliceSize;
        }
        Set<Integer> bobSet = new HashSet<>();
        for (int bobSize : bobSizes) {
            bs += bobSize;
            bobSet.add(bobSize);
        }
        int diff = (as - bs) / 2;
        for (int aliceSize : aliceSizes) {
            if (bobSet.contains(aliceSize - diff)) {
                return new int[]{aliceSize,aliceSize - diff};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Easy888 demo = new Easy888();
        System.out.println(Arrays.toString(demo.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(demo.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(demo.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(demo.fairCandySwap2(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(demo.fairCandySwap2(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(demo.fairCandySwap2(new int[]{2}, new int[]{1, 3})));
    }
}
