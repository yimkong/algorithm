package problems;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem671 {
    int rootVal;
    int res = -1; //核心逻辑就是围绕这个结果进行

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        start(root);
        return res;
    }

    private void start(TreeNode node) {
        if (node == null) {
            return;
        }
        if (res != -1 && node.val >= res) return; //没有结果res的情况，排除已经比现有的结果节点大的节点
        if (node.val > rootVal) res = node.val;//有结果res的情况，比根节点大就更新结果，否则就一直先走这里判断
        start(node.left);
        start(node.right);
    }


}
