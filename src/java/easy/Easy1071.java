package easy;

public class Easy1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str2)) {
            return "";
        }
        int a = str1.length();
        int b = str2.length();
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return str1.substring(0, a);
    }
}
