package leetcode;

public class Easy794 {
    public int minDeletionSize(String[] strs) {
        int c = 0;
        String f = strs[0];
        for (int i = 0; i < f.length(); i++) {
            char ch = f.charAt(i);
            c += sh(strs, i, ch);
        }
        return c;
    }

    private static int sh(String[] strs, int i, char ch) {
        for (int j = 1; j < strs.length; j++) {
            if (ch > strs[j].charAt(i)) {
                return 1;
            }
            ch = strs[j].charAt(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Easy794().minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }
}
