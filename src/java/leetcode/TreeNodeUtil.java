package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtil {
    public static TreeNode buildPreOrder(Integer... preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < preorder.length) {
            TreeNode current = queue.poll();
            if (preorder[i] != null) {
                current.left = new TreeNode(preorder[i]);
                queue.add(current.left);
            }
            i++;
            if (i < preorder.length && preorder[i] != null) {
                current.right = new TreeNode(preorder[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        System.out.println();
    }

}
