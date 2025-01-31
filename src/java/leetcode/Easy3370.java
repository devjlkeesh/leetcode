package leetcode;

public class Easy3370 {
    public int smallestNumber(int n) {
        while (true) {
            if ((n & (n + 1)) == 0) {
                return n;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        Easy3370 e = new Easy3370();
        System.out.println(e.smallestNumber(5));
        System.out.println(e.smallestNumber(15));
        System.out.println(4 & 1);
        int aa = 0b01111111111111111111111111111111;
        int bb = 0b00000000000000000000000000000000;
        System.out.println(aa);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(bb);
        System.out.println(aa & bb);
        System.out.println(";l");
        System.out.println(aa ^ 0);
        System.out.println(bb ^ 0);
        System.out.println(bb ^ 0);
        System.out.println(7 | 8);
        System.out.println(aa ^ 0);
        System.out.println(bb ^ 5);
        System.out.println(bb ^ 6);
        System.out.println(bb ^ 7);
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
    }
}
