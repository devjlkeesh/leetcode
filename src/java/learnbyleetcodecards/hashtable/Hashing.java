package learnbyleetcodecards.hashtable;

import java.util.Random;

public class Hashing {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();
    public String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt(random.nextInt(62)));
            num--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Hashing hashing = new Hashing();
        for (int i = 0; i < 100; i++) {
            System.out.println(hashing.encodeBase62(6));
        }
    }
}
