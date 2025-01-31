package leetcode;

public class Easy717 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length - 1] == 1)
            return false;

        int i;
        for ( i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1){
                i++;
            }
        }
        return i < bits.length;
    }

    public static void main(String[] args) {
        Easy717 obj = new Easy717();
        System.out.println(obj.isOneBitCharacter(new int[]{1,1,0}));
        System.out.println(obj.isOneBitCharacter(new int[]{1,0,0}));
        System.out.println(obj.isOneBitCharacter(new int[]{1,1,1,0}));
    }
}
