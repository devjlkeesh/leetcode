package leetcode;

public class Easy101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.buildPreOrder(1, 2, 2, 3, 4, 4, 3);
        System.out.println(new Easy101().isSymmetric(root));
        System.out.println(new Easy101().isSymmetric(TreeNodeUtil.buildPreOrder(1, 2, 2, null, 3, null, 3)));
        System.out.println(new Easy101().isSymmetric(TreeNodeUtil.buildPreOrder(1, 2, 2, null, 3, 3)));

    }
}
