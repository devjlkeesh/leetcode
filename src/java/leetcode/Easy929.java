package leetcode;

import java.util.HashSet;

public class Easy929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(getNormalEmail(email));
        }
        return set.size();
    }

    private static String getNormalEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int atIndex = email.indexOf('@');
        for (int i = 0; i < atIndex; i++) {
            char c = email.charAt(i);
            if (c == '+') {
                break;
            } else if (c != '.') {
                sb.append(c);
            }
        }
        sb.append(email.substring(atIndex));
        return sb.toString();
    }

    public static void main(String[] args) {
        Easy929 demo = new Easy929();
        System.out.println(demo.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"
        }));
        System.out.println(demo.numUniqueEmails(new String[]{
                "a@leetcode.com", "b@leetcode.com", "c@leetcode.com"
        }));
        System.out.println(demo.numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.email@leetcode.com"
        }));
    }
}
