"""
https://leetcode.cn/problems/sqrtx/description/
"""
#复杂度O(n)
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0: return 0
        i, pre = 1, 1
        while i < x and i * i <= x:
            pre = i
            i = i + 1
        return pre
#复杂度O(Log n), 二分法
class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        res = 0
        while left <= right:
            mid = left + (right - left) // 2
            if mid**2 <= x:
                left = mid + 1
                res = mid
            else:
                right = mid - 1
        return res