package problems;

/**
 * author yg
 * description
 * date 2020/11/14
 */
public class BinaryTreeMaxDepth {

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
