package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class AuthenticationManager {
    private HashMap<String, Integer> map;
    private final int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, ttl + currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer value = map.get(tokenId);
        if (value != null && value < currentTime) {
            map.put(tokenId, ttl + currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        map.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
        return map.size();
    }
}

public class Medium1797 {

    public static void main(String[] args) {
        //["AuthenticationManager","renew","countUnexpiredTokens","countUnexpiredTokens","generate","generate","renew","generate","generate","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","renew","countUnexpiredTokens","countUnexpiredTokens","countUnexpiredTokens","generate","countUnexpiredTokens","renew"]
        //[[13],["ajvy",1],[3],[4],["fuzxq",5],["izmry",7],["puv",12],["ybiqb",13],["gm",14],[15],[18],[19],["ybiqb",21],[23],[25],[26],["aqdm",28],[29],["puv",30]]
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.entrySet().removeIf(entry -> entry.getValue() <= 3);
        System.out.println(map);
    }
}
