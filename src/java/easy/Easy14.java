package easy;

public class Easy14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        for (int i = 0; i < 200; i++) {
            if (i < first.length()) {
                char ch = first.charAt(i);
                for (String str : strs) {
                    if (i >= str.length() || ch != str.charAt(i)) {
                        return prefix.toString();
                    }
                }
                prefix.append(ch);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Easy14 e = new Easy14();
        System.out.println(e.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(e.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(e.longestCommonPrefix(new String[]{"cir", "car"}));
    }
}
