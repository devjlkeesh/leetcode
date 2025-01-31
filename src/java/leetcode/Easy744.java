package leetcode;

public class Easy744 {
    public char nextGreatestLetter(char[] letters, char target) {

            if (target < letters[0] || target >= letters[letters.length - 1]) {
                return letters[0];
            }

            char[] m = new char[26];
            for (char letter : letters) {
                m[letter - 'a']++;
            }
            for (int i = target - 'a'+1; i < 26; i++) {
                if (m[i] > 0) {
                    return (char)(i + 'a');
                }
            }
            return letters[0];
    }

    public static void main(String[] args) {
        Easy744 demo = new Easy744();
        System.out.println(demo.nextGreatestLetter(new char[]{'c', 'j', 'z'}, 'd'));
        System.out.println(demo.nextGreatestLetter(new char[]{'c','f','j'}, 'g'));
        System.out.println(demo.nextGreatestLetter(new char[]{'x','x','y','y'}, 'z'));
    }
}
