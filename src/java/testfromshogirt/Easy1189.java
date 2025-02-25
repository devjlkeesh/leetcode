package testfromshogirt;

import java.util.HashMap;
import java.util.Map;

public class Easy1189 {

    /*Given a string text, you want to use the characters of text
     to form as many instances of the word "balloon" as possible.

You can use each character in text at most once.
 Return the maximum number of instances that can be formed.*/

    public static void main(String[] args) {
        maxNumberOfBalloons("nlaebolko");
        maxNumberOfBalloons("loonbalxballpoon");
        maxNumberOfBalloons("leetcode");
    }

    public static int maxNumberOfBalloons(String text) {
       var map= new HashMap<Character,Integer>();
       map.put('b',0);
       map.put('a',0);
       map.put('l',0);
       map.put('o',0);
       map.put('n',0);
        for (char c : text.toCharArray()) {
            if (check (c)) {
                int count=map.getOrDefault(c,0);
               map.put(c,count+1);
            }
        }

        map.replace('l',map.getOrDefault('l',0)/2);
        map.replace('n',map.getOrDefault('n',0)/2);
       int min= map.values().stream().min(Integer::compareTo).orElse(0);
        System.out.println(min);
        return min;
    }

    public static   boolean check(char c){
        for (char i : "balloon".toCharArray()) {
            if (c==i)
                return true;
        }
        return false;
    }

    }