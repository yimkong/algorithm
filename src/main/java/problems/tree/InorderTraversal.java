package problems.tree;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    //recursive solution,空间复杂度和时间复杂度分别为O(n)
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        startTraversal(root, result);
        return result;
    }

    private void startTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        startTraversal(node.left, result);
        result.add(node.val);
        startTraversal(node.right, result);
    }

    //Morris遍历算法 空间复杂度为O(1)，时间复杂度为O(n)
    //核心思想是每准备向左移动一步，就把左子树的最右边的节点的下一个右节点设置为当前节点
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) { //当前节点判断
            if (root.left != null) {//有左节点则走主要遍历逻辑
                //找出左子树最右边的节点 prececessor
                TreeNode prececessor = root.left;
                while (prececessor.right != null && prececessor.right != root) {
                    prececessor = prececessor.right;
                }
                if (prececessor.right == null) {//将最右边的节点的下一个节点指向root，避免丢失
                    //1。走到最左边节点的时候会设置连接到上一层的父节点
                    prececessor.right = root;
                    root = root.left;//当前节点向左边的节点移动
                } else {
                    //3。当前节点为前一个节点的父节点，进行值添加，并且断开上一个已经访问并取值过的节点的下一个节点，去往右子树
                    result.add(root.val);
                    prececessor.right = null;
                    root = root.right;//去往右子树
                }

            } else {//没有左节点则去右节点
                //2。没有左节点了，把当前节点添加并回去父节点
                result.add(root.val);
                root = root.right;//这也是最后一个右节点的操作，root变成null
            }
        }
        return result;
    }

    //迭代遍历
    public List<Integer> inorderTraversal3(TreeNode root) {
        Deque<TreeNode> objects = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !objects.isEmpty()) {
            while (root != null) {//向左走到底
                objects.push(root);
                root = root.left;
            }
            root = objects.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
