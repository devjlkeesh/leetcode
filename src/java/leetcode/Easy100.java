package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Easy100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new Easy100().isSameTree(TreeNodeUtil.buildPreOrder(1,2,3),TreeNodeUtil.buildPreOrder(1,2,3)));
    }
}
