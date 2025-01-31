package leetcode;

public class Easy3274 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int p11 = coordinate1.charAt(0) - 96;
        int p12 = coordinate1.charAt(1) - '0';
        int p21 = coordinate2.charAt(0) - 96;
        int p22 = coordinate2.charAt(1) - '0';
        if ((p11 + p12) % 2 == 0  && (p21 + p22) % 2 == 0) {
            return true;
        }
        return (p11 + p12) % 2 != 0 && (p21 + p22) % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println('a' - 96);
    }
}
