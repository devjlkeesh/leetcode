package leetcode;

public class Medium1980 {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        int[] map = new int[65536];
        for (String num : nums) {
            map[Integer.parseInt(num, 2)] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                String binaryString = Integer.toBinaryString(i);
                if (binaryString.length() == len) {
                    return binaryString;
                }
            }
        }
        return "0".repeat(len);
    }

    public String findDifferentBinaryString2(String[] nums) {
        int len = nums[0].length();


        return "0".repeat(len);
    }

    public static void main(String[] args) {
        Medium1980 m = new Medium1980();
        System.out.println(m.findDifferentBinaryString(new String[]{"10", "11"}));
    }
}
