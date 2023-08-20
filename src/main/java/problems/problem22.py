"""
https://leetcode.cn/problems/generate-parentheses/description/

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]

提示：

1 <= n <= 8
"""

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.list = []
        self._gen(0, 0, n, "")
        return self.list
    def _gen(self, left, right, n, case):
        if left == n and right == n:
            self.list.append(case)
            return
        if left < n:
            self._gen(left + 1, right, n, case + "(")
        if right < n and right < left:
            self._gen(left, right + 1, n, case + ")")

#以下是只考虑剩余左括号和右括号的情况
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.list = []
        self._gen(n, n, "")
        return self.list
    def _gen(self, left, right, case):
        if left == 0 and right == 0:
            self.list.append(case)
            return
        if left > 0:
            self._gen(left - 1, right, case + "(")
        if right > 0 and right > left:
            self._gen(left, right - 1, case + ")")
