package leetcode;

public class Easy806 {

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int curLineWidth = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (curLineWidth + width > 100) {
                lines++;
                curLineWidth = width;
            } else {
                curLineWidth += width;
            }
        }
        return new int[]{lines, curLineWidth};
    }

    public static void main(String[] args) {
        Easy806 demo = new Easy806();
        System.out.println(demo.numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }

}
