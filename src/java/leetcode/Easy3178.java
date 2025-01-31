package leetcode;

public class Easy3178 {
    public int numberOfChild(int n, int k) {
        if (k < n){
            return k;
        }
        boolean leftToRight = true;
        while (k > n){
            leftToRight = !leftToRight;
            k -=(n - 1);
        }
        if (leftToRight){
            return k;
        }else{
            return n - k - 1;
        }
    }
}
