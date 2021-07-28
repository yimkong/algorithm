package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem863 {
    Map<Integer, TreeNode> parentNode = new HashMap<>();
    List<Integer> res = new LinkedList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findDistanceK(target, null, 0, k);
        return res;
    }

    /**
     * 理解逻辑，从目标节点出发，有三条路走，向左和向右以及向父节点，向父节点的走法又会在目标节点的子节点生效，因此为了防止重复
     * 访问已经访问过的节点，需要加上!=上一个节点的判断，向子节点的走法又会在目标节点的父节点生效，因此也要判断!=上一个节点
     * @param node 目标节点
     * @param from   来源节点 有可能是目标节点的父节点或者子节点
     * @param depth  距离目标节点的当前深度
     * @param k      要求的深度
     */
    private void findDistanceK(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {//往目标节点的左节点找，有可能父节点向目标节点走
            findDistanceK(node.left, node, depth + 1, k);
        }
        if (node.right != from) {//往目标节点的右节点找，有可能父节点向目标节点走
            findDistanceK(node.right, node, depth + 1, k);
        }
        TreeNode parent = parentNode.get(node.val);
        if (parent != from) {//有可能目标节点子节点向父节点走
            findDistanceK(parent, node, depth + 1, k);
        }
    }

    private void findParents(TreeNode root) {
        //把所有的节点的父节点保存起来
        if (root.left != null) {
            parentNode.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null) {
            parentNode.put(root.right.val, root);
            findParents(root.right);
        }
    }
}
