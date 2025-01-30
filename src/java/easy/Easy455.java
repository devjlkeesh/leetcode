package easy;

import java.util.Arrays;

public class Easy455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Easy455 obj = new Easy455();
        System.out.println(obj.findContentChildren(new int[]{1,2,3},new int[]{1,1}));
        System.out.println(obj.findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
}
