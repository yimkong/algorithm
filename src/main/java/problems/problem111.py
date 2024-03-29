"""
https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。
"""
DFS ：用递归
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        return self.go(root, 0)

    def go(self, node, level):
        if not node: return level

        if not node.left: return self.go(node.right, level + 1)
        if not node.right: return self.go(node.left, level + 1)

        level = level + 1
        return min(self.go(node.left, level), self.go(node.right, level))

BFS：遍历每一层
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        level = 0
        list = [root]
        while list:
            level = level + 1
            #遍历目前这一层所有的子节点
            for _ in range(len(list)):
                node = list.pop(0)
                #只要有任何一个节点没有左右子节点，则当前level是最小深度
                if not node.left and not node.right: return level
                if node.left: list.append(node.left)
                if node.right: list.append(node.right)
        return level