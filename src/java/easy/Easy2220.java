package easy;

public class Easy2220 {
    public int minBitFlips(int start, int goal) {
        if (start == goal) {
            return 0;
        }
        int count = 0;
        String startBits = Integer.toBinaryString(start);
        String goalBits = Integer.toBinaryString(goal);
        int i = goalBits.length() - 1;
        int j = startBits.length() - 1;
        while (i >= 0 && j >= 0) {
            if (goalBits.charAt(i) != startBits.charAt(j)) {
                count++;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (goalBits.charAt(i) != '0') {
                count++;
            }
            i--;
        }
        while (j >= 0) {
            if (goalBits.charAt(j) != '0') {
                count++;
            }
            j--;
        }
        return count;
    }

    public int minBitFlips2(int start, int goal) {
        if (start == goal) {
            return 0;
        }
        int count = 0;
        int ir = start%2;
        int jr = goal%2;
        while (start > 0 || goal > 0){
            if (ir != jr){
                count++;
            }
            start /= 2;
            goal /= 2;
            ir = start % 2;
            jr = goal % 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Easy2220 obj = new Easy2220();
        System.out.println(obj.minBitFlips(10, 7));
        System.out.println(obj.minBitFlips(10, 82));
        System.out.println(obj.minBitFlips(97, 21));
        System.out.println("version 2");
        System.out.println(obj.minBitFlips2(10, 7));
        System.out.println(obj.minBitFlips2(10, 82));
        System.out.println(obj.minBitFlips2(97, 21));
    }
}
