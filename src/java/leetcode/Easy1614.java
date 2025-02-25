package leetcode;

public class Easy1614 {
    public int maxDepth(String s) {
        int lc = 0;
        int rc = 0;

        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lc++;
                max = Math.max(max, lc - rc);
            }else if(c == ')'){
                rc++;
                max = Math.max(max, lc - rc);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Easy1614().maxDepth("()(())((()()))"));
        System.out.println(new Easy1614().maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
