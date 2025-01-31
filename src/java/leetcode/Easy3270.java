package leetcode;

public class Easy3270 {
    public int generateKey(int num1, int num2, int num3) {
        int key = 0, p = 1;
        while (num1 != 0 && num2 != 0 && num3 != 0) {
            key = Math.min(num3 % 10, Math.min(num1 % 10, num2 % 10)) * p + key;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            p *= 10;
        }
       return key;
    }

    public static void main(String[] args) {
        Easy3270 e = new Easy3270();
        System.out.println(e.generateKey(1, 10, 1000));
        System.out.println(e.generateKey(957, 879, 398));
        System.out.println(e.generateKey(1, 2, 3));
    }
}
