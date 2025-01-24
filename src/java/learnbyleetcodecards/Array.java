package learnbyleetcodecards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int digitCount = 0;
            while (num > 0) {
                digitCount++;
                num /= 10;
            }
            if (digitCount % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            if (leftValue > rightValue) {
                result[i] = leftValue;
                left++;
            } else {
                result[i] = rightValue;
                right--;
            }
            i--;
        }
        return result;
    }

    public void duplicateZeros(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int zeros = 0;
        for (int j : arr) {
            if (j == 0) {
                zeros++;
            }
        }
        int[] nrr = new int[zeros + arr.length];
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                nrr[j++] = 0;
                nrr[j++] = 0;
            } else {
                nrr[j++] = arr[i];
            }
            System.out.println(i + " nrr=>" + Arrays.toString(nrr));
            System.out.println(i + " arr=>" + Arrays.toString(arr));
            i++;
        }

        System.arraycopy(nrr, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }


        System.out.println("remove =>" + Arrays.toString(nums));
        return k;
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || set.contains(num / 2) && num % 2 == 0)
                return true;
            set.add(num);
        }
        return false;
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i + 1 < j && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == j) {
            return false;
        }
        while (i + 1 < j && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == j - 1;
    }

    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }


    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 != 0) {
                if (nums[j] % 2 == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(heights);
        int k = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                k++;
            }
        }
        return k;
    }

    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2 && num < m1) {
                m3 = m2;
                m2 = num;
            } else if (num > m3 && num < m2) {
                m3 = num;
            }
        }
        if (m3 == Long.MIN_VALUE) {
            return (int) m1;
        } else {
            return (int) m3;
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*int[] m = new int[nums.length+1];
        for (int num : nums) {
            m[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            if (m[i] == 0) {
                result.add(i);
            }
        }*/
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num > 0){
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        Array solution = new Array();
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));
        solution.duplicateZeros(nums);
        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        int k = solution.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println("k = " + k);
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println("solution.checkIfExist(new int[]{10,2,5,3}) = " + solution.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(solution.validMountainArray(new int[]{2, 0, 2}));
        System.out.println(solution.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        System.out.println(solution.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        System.out.println(Arrays.toString(solution.replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(solution.replaceElements(new int[]{400})));

        /*
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
         */
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
        solution.sortArrayByParity(new int[]{3, 1, 2, 4});
        solution.sortArrayByParity(new int[]{0});
        System.out.println(solution.thirdMax(new int[]{1, 2}));
        System.out.println(solution.thirdMax(new int[]{1, 1, 2}));
        System.out.println(solution.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

    }
}
