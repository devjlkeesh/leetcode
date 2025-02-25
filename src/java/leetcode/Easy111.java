package leetcode;

public class Easy111 {

    public int minDepth(TreeNode root) {
        return minDepth(0, root);
    }

    public int minDepth(int depth, TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            int left = minDepth(depth + 1, root.left);
            int right = minDepth(depth + 1, root.right);
            return Math.min(left, right) + 1;
        }
        return minDepth(depth + 1, root.left == null ? root.right : root.left) + 1;
    }

    public static void main(String[] args) {
        Easy111 demo = new Easy111();
        System.out.println(demo.minDepth(TreeNodeUtil.buildPreOrder(3, 9, 20, null, null, 15, 7)));
        System.out.println(demo.minDepth(TreeNodeUtil.buildPreOrder(2, null, 3, null, 4, null, 5, null, 6)));
    }

}
