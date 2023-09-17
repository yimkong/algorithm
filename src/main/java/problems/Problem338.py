
"""
https://leetcode.cn/problems/counting-bits/description/
"""

class Solution:
    def countBits(self, n: int) -> List[int]:
        dic = {}
        ans = []
        for i in range(n + 1):
            if i == 0:
                ans.append(0)
                dic[i] = 0
            else:
                # 去掉一个最右边的1后的数字，需要继续判断有几个1，因此可以把结果缓存在map里面
                count = dic.get(i & i - 1, 0)
                ans.append(count + 1)
                dic[i] = count + 1
        return ans