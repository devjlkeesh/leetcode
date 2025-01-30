package easy;

public class Easy605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int firstOneIndex = -1;
        int l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Easy605 demo = new Easy605();
        System.out.println(demo.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(demo.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}
