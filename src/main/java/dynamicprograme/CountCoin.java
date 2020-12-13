package dynamicprograme;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author yg
 * description
 * 数硬币问题：
 * 给出n种硬币面值的list,每种硬币数量无限,最少几枚硬币凑出amount，不可能凑出则返回-1
 * date 2020/12/13
 */
public class CountCoin {
    private static List<Integer> coins;

    //暴力枚举,每一次遍历都将当前amount减去其中一个硬币，重复到直到为0或者为负数为止 时间复杂度等于子问题的个数n*k 乘以子问题的时间1 结果为 O(n^2)
    public static int countCoin(List<Integer> coins, int amount) {
        CountCoin.coins = coins;
        return helper(amount);
    }

    private static int helper(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int temp = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subProblem = helper(amount - coin);
            if (subProblem == -1) {
                continue;
            }
            temp = Math.min(subProblem + 1, temp);
        }
        return temp;
    }

    private static Map<Integer, Integer> memTable = new HashMap<>();

    //自顶向下 带memo记忆表,复杂度为O(n)
    public static int countCoin1(List<Integer> coins, int amount) {
        CountCoin.coins = coins;
        int i = helper1(amount);
        return i;
    }

    private static int helper1(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memTable.get(amount) != null) {
            return memTable.get(amount);
        }
        int temp = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subProblem = helper1(amount - coin);
            if (subProblem == -1) {
                continue;
            }
            temp = Math.min(subProblem + 1, temp);
        }
        //每一轮后保存最小的硬币枚数
        int value = temp == Integer.MAX_VALUE ? -1 : temp;
        memTable.put(amount, value);
        return value;
    }

    //自底向上
    public static int countCoin2(List<Integer> coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //用于刚好扣完计算，amount为0，数量为0
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            //下标i表示amount,dp[i]表示最小硬币数
            for (Integer coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                //+1是因为上一步的i-coin满足条件，说明可以加一枚硬币，再加上当前i面值扣去coin币值后的币可以凑出的最小值（已保存在数组）
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
