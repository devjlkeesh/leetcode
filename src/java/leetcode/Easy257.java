package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        binaryTreePaths(answer, new StringBuilder(), root);
        return answer;
    }

    public void binaryTreePaths(List<String> answer, StringBuilder path, TreeNode root) {
        if (root == null) return;
        int len = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null)
            answer.add(path.toString());
        path = path.append("->");
        binaryTreePaths(answer, path, root.left);
        binaryTreePaths(answer, path, root.right);
        path.setLength(len);
    }

    public static void main(String[] args) {
        Easy257 easy257 = new Easy257();
        System.out.println(easy257.binaryTreePaths(TreeNodeUtil.buildPreOrder(1, 2, 3, null, 5)));
    }

}
