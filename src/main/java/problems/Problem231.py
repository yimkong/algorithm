
"""
https://leetcode.cn/problems/power-of-two/description/
"""

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # 从二进制来说，有且仅有一个1，因此去掉最右边的一个1后需要为0，0则是False
        return n > 0 and not (n & (n - 1))