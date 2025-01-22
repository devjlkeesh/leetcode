package easy;

import java.util.Arrays;

public class Easy344 {
    public void reverseString(char[] s) {
        if (s.length == 1){
            return;
        }
        int i = 0, j = s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Easy344 solution = new Easy344();
        char[] s = {'h', 'e', 'l', 'l'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
