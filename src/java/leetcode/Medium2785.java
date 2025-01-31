package leetcode;

public class Medium2785 {

    public String sortVowels(String s) {
        char[] chars = new char[s.length()];
        int[] vowels = new int[58];
        vowels[0] = 1;
        vowels[4] = 1;
        vowels[8] = 1;
        vowels[14] = 1;
        vowels[20] = 1;
        vowels[32] = 1;
        vowels[36] = 1;
        vowels[40] = 1;
        vowels[46] = 1;
        vowels[52] = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels[c - 65] != 0) {
                vowels[c - 65]++;
            } else {
                chars[i] = c;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                int j = 0;
                while (vowels[j] <= 1) {
                    j++;
                }
                vowels[j]--;
                chars[i] = (char) (j + 'A');
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Medium2785 m = new Medium2785();
        System.out.println(m.sortVowels("lEetcOde"));
        System.out.println(m.sortVowels("lYmpH"));

    }
}
