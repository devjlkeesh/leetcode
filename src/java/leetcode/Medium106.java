package leetcode;

import java.util.HashMap;

public class Medium106 {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(postorder, 0, postOrderIndex);
    }

    private TreeNode constructTree(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int val = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(val);
        Integer i = inorderMap.get(val);
        root.right = constructTree(postorder, i + 1, inRight);
        root.right = constructTree(postorder, inLeft, i - 1);
        return root;
    }
}
