package problems;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBS {

    public boolean isValidBST(TreeNode root) {
        return isInBound(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isInBound(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if(root.val<=minValue || root.val>=maxValue) return false;
        boolean re1= isInBound(root.left,minValue,root.val);
        if(!re1) return false;
        re1 = isInBound(root.right,root.val,maxValue);
        if(!re1) return false;
        return true;
    }

}
