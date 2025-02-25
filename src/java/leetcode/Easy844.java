package leetcode;

public class Easy844 {
    public boolean backspaceCompare(String s, String t) {
        return trim(s).equals(trim(t));
    }

    private String trim(String s) {
        StringBuilder sb = new StringBuilder();
        int hashTagCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                hashTagCount++;
            } else if (hashTagCount > 0) {
                hashTagCount--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Easy844 demo = new Easy844();
        System.out.println(demo.backspaceCompare("ab#cd#", "ad#c"));
    }
}
