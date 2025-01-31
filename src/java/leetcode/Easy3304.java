package leetcode;

public class Easy3304 {
    public char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }
        int j = 1;
        char prev = 'a';
        int l = 1;
        while (l < k) {
            for (int i = 0; i < k; i++) {
                prev = (char) ((prev - 'a' + 1) % 26 + 'a');
                l++;
                if (l == k) {
                    return prev;
                }
            }
            l++;

        }
        System.out.println(prev);
        return prev;
    }

    public static void main(String[] args) {
        Easy3304 easy3304 = new Easy3304();
        System.out.println(easy3304.kthCharacter(5));
    }
}
