"""
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
"""
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        res = 0
        profit = [[0 for i in range(2)] for i in range(len(prices))]
        #有股票，没有股票
        profit[0][0], profit[0][1] =  - prices[0], 0
        for i in range(1, len(prices)):
            #前一天就有股票或者没有股票今天才买
            profit[i][0] = max(profit[i - 1][0], - prices[i])
            #前一天有股票，今天卖掉了
            profit[i][1] = profit[i - 1][0] + prices[i]
            res = max(res, profit[i][1])
        return res

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0 for i in range(2)] for j in range(n)]
        for i in range(n):
            if i - 1 == -1:
                # base case
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            #没有股票，昨天就没有，或者今天卖掉的。后者为完整的一次买卖的交易。需要考虑到有可能利润为负数，例如prices = [7,6,4,3,1]，因此和一开始的0比较，取最大利润
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            #有一股，昨天就有一股，或者今天买的
            dp[i][1] = max(dp[i-1][1],  - prices[i])
        return dp[n-1][0]