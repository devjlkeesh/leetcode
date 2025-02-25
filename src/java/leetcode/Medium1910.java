package leetcode;

public class Medium1910 {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int i ;
        int pl = part.length();
        while ((i = sb.indexOf(part)) != -1) {
            sb.delete(i, i +pl);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium1910 m = new Medium1910();
        System.out.println(m.removeOccurrences("axxxyyyb", "xy"));
    }
}
