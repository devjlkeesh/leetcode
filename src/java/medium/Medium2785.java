package medium;

public class Medium2785 {

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        // A, E, I, O, U
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {

            } else {
                sb.setCharAt(i, s.charAt(i));
            }
        }
        return "";
    }
}
