package easy;

public class Easy434 {
    public int countSegments(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int segment = 0;
        char prev = ' ';
        for (char ch: s.toCharArray()){
            if (ch == ' ' && prev != ' '){
                segment++;
            }
            prev = ch;
        }
        return s.charAt(s.length()-1) == ' ' ? segment : segment + 1;
    }

    public static void main(String[] args) {

    }
}
