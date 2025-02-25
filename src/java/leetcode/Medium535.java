package leetcode;

import java.util.HashMap;
import java.util.Random;

class Codec {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();
    private final HashMap<String, String> map = new HashMap<>();

    public String hash() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 6) {
            sb.append(BASE62.charAt(random.nextInt(62)));
            i++;
        }
        String hash = sb.toString();
        if (map.containsKey(hash)) {
            return hash();
        }
        return hash;
    }

    public String encode(String longUrl) {
        String hash = hash();
        map.put(hash, longUrl);
        return hash;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

public class Medium535 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.encode("https://leetcode.com/problems/medium535/"));
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/medium535/")));
    }
}
