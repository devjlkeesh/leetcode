package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraversal(answer, root);
        return answer;
    }
    public void postorderTraversal(List<Integer> answer,TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(answer, root.left);
        postorderTraversal(answer, root.right);
        answer.add(root.val);
    }
}
