package leetcode;

public class Eas222 {
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
    public int countNodes(TreeNode root) {
        return countNodes(0, root);
    }

    public int countNodes(int c, TreeNode root) {
        if (root == null) {
            return c;
        }
        c+=1;
        c=countNodes(c, root.left);
        c=countNodes(c, root.right);
        return c;
    }

    public static void main(String[] args) {
        Eas222 e = new Eas222();
        System.out.println(e.countNodes(TreeNodeUtil.buildPreOrder(1,2,3,4,5,6)));
        System.out.println(e.countNodes(TreeNodeUtil.buildPreOrder(1)));
        System.out.println(e.countNodes(null));
    }
}
