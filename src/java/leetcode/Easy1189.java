package leetcode;

public class Easy1189 {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (int n = text.length() - 1; n >= 0; n--) {
            counts[text.charAt(n) - 'a']++;
        }
        // balloon
        int res = 0;
        counts[11] /= 2;
        counts[14] /= 2;
        while (counts[0] > 0 && counts[1] > 0 && counts[11] > 0 && counts[13] > 0 && counts[14] > 0) {
            res++;
            counts[0]--;
            counts[1]--;
            counts[11]--;
            counts[13]--;
            counts[14]--;
        }
        return res;
    }
    public int maxNumberOfBalloons2(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for (int i = text.length() - 1; i >= 0; i--) {
            switch (text.charAt(i)) {
                case 'a'-> a++;
                case 'b'-> b++;
                case 'l'-> l++;
                case 'o'-> o++;
                case 'n'-> n++;
            }
        }
        l/=2;o/=2;
        return Math.min(Math.min(a,b),Math.min(l,Math.min(o,n)));
    }

    public static void main(String[] args) {
        System.out.println('o' - 97);
        System.out.println('l' - 97);
        System.out.println('n' - 97);
    }
}
