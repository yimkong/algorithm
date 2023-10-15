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