package leetcode;

public class Medium1524 {
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Medium1524 m = new Medium1524();
        System.out.println(m.numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(m.numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }
}
