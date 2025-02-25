package leetcode;

import java.util.Stack;

public class Easy1598 {
    public int minOperations(String[] logs) {
        int n = 0;
        StringBuilder a = new StringBuilder();
        for (String log : logs) {
            if (log.length() > 2 || log.charAt(0) != '.') {
                a.setLength(0);
                for (int i = 0; i < log.length(); i++) {
                    char ch = log.charAt(i);
                    if (ch == '/') {
                        if (a.toString().equals("..")) {
                            if (n > 0) {
                                n--;
                            }
                        } else {
                            n++;
                        }
                        a.setLength(0);
                    } else {
                        a.append(ch);
                    }
                }
            }
        }
        return n;
    }

    public int minOperations2(String[] logs) {
        int n = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                n = Math.max(n - 1, 0);
            } else if (!log.equals("./")) {
                n++;
            }
        }
        return n;
    }

    public int minOperations3(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!log.equals("./")) {
                stack.push(log);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Easy1598 demo = new Easy1598();
        System.out.println(demo.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(demo.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(demo.minOperations(new String[]{"d1/", "../", "../", "../"}));
        System.out.println(demo.minOperations(new String[]{"1/"}));
        System.out.println(demo.minOperations(new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}));
        System.out.println("----");
        System.out.println(demo.minOperations2(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(demo.minOperations2(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(demo.minOperations2(new String[]{"d1/", "../", "../", "../"}));
        System.out.println(demo.minOperations2(new String[]{"1/"}));
        System.out.println(demo.minOperations2(new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}));
    }
}
