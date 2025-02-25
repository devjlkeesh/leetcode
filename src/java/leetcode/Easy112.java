package leetcode;

public class Easy112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return inorderTraversal(targetSum, root);
    }

    public boolean inorderTraversal(int sum, TreeNode root) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return inorderTraversal(sum, root.left) || inorderTraversal(sum, root.right);
    }

    public static void main(String[] args) {
        Easy112 demo = new Easy112();
        System.out.println(demo.hasPathSum(TreeNodeUtil.buildPreOrder(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22));
    }

}
