package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorderTraversal(answer, root);
        return answer;
    }

    public void preorderTraversal(List<Integer> answer, TreeNode root) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        preorderTraversal(answer, root.left);
        preorderTraversal(answer, root.right);
    }

}
