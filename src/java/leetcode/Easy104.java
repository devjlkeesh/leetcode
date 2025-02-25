package leetcode;

public class Easy104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(0, root);
    }

    public int maxDepth(int depth, TreeNode root) {
        if (root == null) {
            return depth;
        }
        int left = maxDepth(depth + 1, root.left);
        int right = maxDepth(depth + 1, root.right);
        return Math.max(left, right);
    }

    public int maxDepthDownTop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepthDownTop(root.left);
        int right = maxDepthDownTop(root.right);
        return Math.max(left, right) + 1;
    }

}
