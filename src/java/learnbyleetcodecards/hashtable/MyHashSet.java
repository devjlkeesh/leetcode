package learnbyleetcodecards.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MyHashSet {

    public int singleNumber(int[] nums) {
        boolean a = true;
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        int hashSetSum = 0;
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
                hashSetSum += num;
            }
            sum += num;
        }
        return hashSetSum * 2 - sum;
//        int sum = 0;
//        for (int num : nums) {
//                sum ^= num;
//        }
//        return sum;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int[] m = new int[1001];
        for (int num : nums1) {
            m[num] = 1;
        }
        int count = 0;
        for (int num : nums2) {
            if (m[num] == 1) {
                m[num] = 2;
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < 1001; i++) {
            if (m[i] == 2) {
                result[count-- - 1] = i;
            }
        }
        return result;
    }

    private int[] d(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums2) {
            if (Arrays.binarySearch(nums1, i) >= 0) {
                hashSet.add(i);
            }
        }
        return hashSet.stream().mapToInt(i -> i).toArray();
    }

    public boolean isHappy(int n) {
        var set = new HashSet<>();
        while (n != 1) {
            if (!set.add(n)) {
                return false;
            }
            n = digitSum(n);
        }
        return true;
    }

    int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        return sum;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (!map2.containsValue(e.getValue())) {
                return false;
            } else if (e.getKey().equals(map2.get(e.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            String word = list1[i];
            map.put(word, Math.min(map.getOrDefault(word, i), i));
        }
        int min = Integer.MAX_VALUE;
        String[] result = new String[Math.min(list1.length, list2.length)];
        int counter = 0;
        for (int i = 0; i < list2.length; i++) {
            String word = list2[i];
            if (map.containsKey(word)) {
                if (map.get(word) + i < min) {
                    result[0] = word;
                    min = map.get(word) + i;
                    counter = 1;
                } else if (map.get(word) + i == min) {
                    result[counter++] = word;
                }
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = HashMap.newHashMap(26);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
                min = Math.min(min, i);
            }
        }
        return map.values().stream().filter(a -> a != -1).min(Integer::compareTo).orElse(-1);
    }

    public int firstUniqChar_v2(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] m = new int[1001];
        for (int n : nums1) {
            m[n]++;
        }
        int[] result = new int[nums1.length];
        int i = 0;
        for (int n : nums2) {
            if (m[n] > 0) {
                result[i++] = n;
                m[n]--;
            }
        }
        return Arrays.copyOf(result, i);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = key(s);
            List<String> item = map.get(key);
            if (item != null) {
                item.add(s);
            } else {
                item = new ArrayList<>();
                item.add(s);
                map.put(key, item);
            }
        }
        return map.values().stream().toList();
    }

    public String key(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];
                if (cell != '.' && !rowSet.add(cell)) {
                    return false;
                }
                char cell2 = board[j][i];
                if (cell2 != '.' && !rowSet.add(cell)) {
                    return false;
                }
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> subgridSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char cell = board[row + i][col + j];
                        if (cell != '.' && !subgridSet.add(cell)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                int subgridIndex = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(num) || cols[j].contains(num) || grids[subgridIndex].contains(num)) {
                    return false;
                }
                rows[i].add(num);
                cols[j].add(num);
                grids[subgridIndex].add(num);
            }
        }
        return true;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int n = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char ch : jewels.toCharArray()) {
            if (map.containsKey(ch)) {
                n += map.get(ch);
            }
        }
        return n;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int n = 0;
        int[] ch = new int[128];
        for (int c : stones.toCharArray()) {
            ch[c]++;
        }
        for (int c : jewels.toCharArray()) {
            n += ch[c];
        }
        return n;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                int n = -(c + d);
                count += map.getOrDefault(n, 0);
            }
        }
        return count;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    int valueComparison = Integer.compare(a.getValue(), b.getValue());
                    if (valueComparison == 0) {
                        return Integer.compare(a.getKey(), b.getKey());
                    }
                    return valueComparison;
                }
        );
        for (int i = 0; i < nums.length; i++) {
            pq.add(Map.entry(i, nums[i]));
        }

        for (int i = 0; i < k; i++) {
            var entry = pq.poll();
            pq.add(Map.entry(entry.getKey(), entry.getValue() * multiplier));
        }
        while (!pq.isEmpty()) {
            var entry = pq.poll();
            nums[entry.getKey()] = entry.getValue();
        }
        return nums;
    }

    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = min * multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        System.out.println(hashSet.singleNumber(new int[]{2, 2, 3}));
        System.out.println(hashSet.singleNumber(new int[]{2, 2, 1}));
        System.out.println(hashSet.singleNumber(new int[]{1}));
        System.out.println(Arrays.toString(hashSet.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(hashSet.findRestaurant(new String[]{"happy", "sad", "good"}, new String[]{"sad", "happy", "good"})));
        System.out.println(Arrays.toString(hashSet.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(hashSet.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
        System.out.println(Arrays.toString(hashSet.findRestaurant(new String[]{"vacag", "KFC"}, new String[]{"fvo", "xrljq", "jrl", "KFC"})));
        System.out.println(Arrays.toString(hashSet.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(hashSet.intersect(new int[]{2, 2}, new int[]{1, 2, 2, 1})));
        System.out.println(hashSet.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(hashSet.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println((int) 'a');
        System.out.println((int) 'z' - 65);
        System.out.println((int) 'A' - 65);
        System.out.println((int) 'Z');
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(5);

        System.out.println("sdfd");
        int i = 4;
        while (i > 0) {
            System.out.println(pq.poll());
            i--;
        }
        System.out.println(Arrays.toString(hashSet.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        System.out.println(Arrays.toString(hashSet.getFinalState2(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        //0 1 2 3 4

        // Operation	Result
        // After operation 1	[2, 2, 3, 5, 6]
        // After operation 2	[4, 2, 3, 5, 6]
        // After operation 3	[4, 4, 3, 5, 6]
        // After operation 4	[4, 4, 6, 5, 6]
        // After operation 5	[8, 4, 6, 5, 6]
    }

}
