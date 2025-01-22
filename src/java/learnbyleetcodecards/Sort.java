package learnbyleetcodecards;

public class Sort {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int blueCount = 0;
        int greenCount = 0;
        for (int num : nums) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                blueCount++;
            } else {
                greenCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (redCount > 0) {
                nums[i] = 0;
                redCount--;
            } else if (blueCount > 0) {
                nums[i] = 1;
                blueCount--;
            } else if (greenCount > 0) {
                nums[i] = 2;
                greenCount--;
            }
        }
    }


    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] != heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                k++;
            }
        }
        return k;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;

    }

}
