package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author yg
 * description
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *          1
 *        / | \
 *       3  2  4
 *      /\
 *     5  6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * date 2020/6/30
 */
public class NTreeAll {
    //==================迭代的方式===========================
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> objects = new ArrayList<>();
        LinkedList<Node> toGetVal = new LinkedList<>();
        while (root != null && root.children != null) {
            objects.add(root.val);
            List<Node> children = root.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                toGetVal.addFirst(children.get(i));
            }
            root = toGetVal.poll();
        }
        return objects;
    }

    //====================递归的方式=========================
//    public List<Integer> preorder(Node root) {
//        ArrayList<Integer> objects = new ArrayList<>();
//        add(objects, root);
//        return objects;
//    }
//
//    private void add(ArrayList<Integer> objects, Node root) {
//        if (root == null) {
//            return;
//        }
//        objects.add(root.val);
//        List<Node> children = root.children;
//        if (children != null) {
//            for (Node child : children) {
//                add(objects, child);
//            }
//        }
//    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};