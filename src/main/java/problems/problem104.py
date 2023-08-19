"""
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
"""
DFS ：用递归
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return self.go(root, 0)

    def go(self, node, level):
        if not node: return level
        level = level + 1
        return max(self.go(node.left, level), self.go(node.right, level))

class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        # 排除只有左边或者右边的情况，其他情况就取左右俩边最小深度+1
        return left + right + 1 if not left or not right else min(left, right) + 1
