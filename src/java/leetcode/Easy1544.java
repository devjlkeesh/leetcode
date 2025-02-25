package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Easy1544 {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (!stack.isEmpty()) {
                char bch = stack.peek();
                if (c != bch) {
                    if (Character.isLowerCase(c)) {
                        if (c == Character.toLowerCase(bch)) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        if (c == Character.toUpperCase(bch)) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    }
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String makeGood2(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char bch = stack.peek();
                if (Character.toLowerCase(c) == Character.toLowerCase(bch)) {
                    if (Character.isLowerCase(c) && Character.isUpperCase(bch) || Character.isUpperCase(c) && Character.isLowerCase(bch)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String makeGood3(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (sb.isEmpty()) {
                sb.append(c);
            } else {
                char bch = sb.charAt(sb.length() - 1);
                if (Character.toLowerCase(c) == Character.toLowerCase(bch)) {
                    if (Character.isLowerCase(c) && Character.isUpperCase(bch) || Character.isUpperCase(c) && Character.isLowerCase(bch)) {
                        sb.setLength(sb.length() - 1);
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String makeGood4(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (sb.isEmpty()) {
                sb.append(c);
            } else {
                char bch = sb.charAt(sb.length() - 1);
                if (Math.abs(c - bch) == 32) {
                    sb.setLength(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String makeGood5(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char bch =stack.peek();
                if (Math.abs(c - bch) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Easy1544 demo = new Easy1544();
        System.out.println(demo.makeGood("leEeetcode"));
        System.out.println(demo.makeGood("abBAcC"));
        System.out.println(demo.makeGood("s"));
        System.out.println(demo.makeGood2("leEeetcode"));
        System.out.println(demo.makeGood2("abBAcC"));
        System.out.println(demo.makeGood2("s"));
        System.out.println(demo.makeGood3("leEeetcode"));
        System.out.println(demo.makeGood3("abBAcC"));
        System.out.println(demo.makeGood3("s"));
        System.out.println(demo.makeGood4("leEeetcode"));
        System.out.println(demo.makeGood4("abBAcC"));
        System.out.println(demo.makeGood4("s"));

    }
}
