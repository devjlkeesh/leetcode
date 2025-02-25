package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Easy94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderTraversal(answer, root);
        return answer;
    }
    public void inorderTraversal(List<Integer> answer,TreeNode root) {
        if (root == null) {
            return ;
        }
        inorderTraversal(answer, root.left);
        answer.add(root.val);
        inorderTraversal(answer, root.right);
    }

    public static void main(String[] args) {
        Easy94 easy94 = new Easy94();
        TreeNode root = TreeNodeUtil.buildPreOrder(1,2,3,4,5,null,8,null,null,6,7,9);
        System.out.println(easy94.inorderTraversal(root));
    }
}
