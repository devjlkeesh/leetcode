package leetcode;

import java.util.HashMap;

public class Medium105 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder  =>  root, left, right
        // inorder   =>  left, root, right
        // postorder =>  left, right, root
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode constructTree(int[] preorder, int l, int r) {
        if (l > r) return null;
        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        root.left = constructTree(preorder, l, i - 1);
        root.right = constructTree(preorder, i + 1, r);
        return root;
    }
}
