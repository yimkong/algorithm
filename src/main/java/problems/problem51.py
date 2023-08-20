"""
https://leetcode.cn/problems/n-queens/description/

按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



示例 1：


输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]


提示：

1 <= n <= 9
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def _DFS(cols, left, right):
            s = len(cols)#当前行，第几行
            if s == n:
                result.append(cols)
                return
            for c in range(n):#每一行遍历所有列
                if c not in cols and c + s not in left and c - s not in right:
                    _DFS(cols + [c], left + [c + s], right + [c - s])
        result = []
        _DFS([], [], [])
        return [[ "." * q + "Q" + "." * (n - q - 1) for q in p] for p in result]
