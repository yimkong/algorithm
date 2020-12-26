package dynamicprograme;

/**
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {
    public static int minDistance(String word1, String word2) {
        //dp[i][j] i代表word1前i个字符 j代表word2前j个字符  所需要的最小操作
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化需要的值
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        //想象最后一个字符操作，只能是以下选项：删除/替换/插入/不变，前三个最终都要+1操作，不变则不用
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //第i个字符和第j个字符相等，则不需要操作，即和word1前i-1个字符 word2前j-1个字符  所需要的最小操作相等
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    //空间复杂度优化通过矩阵优化，额外存储一个dp[i-1,j-1],另外俩个存在一维数组
    public static int minDistance2(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        //初始化j数组 用于做四格运算
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int temp;
        for (int i = 1; i < word1.length() + 1; i++) {
            //每一行开始，保存初始值dp[0][0]
            temp = dp[0];
            dp[0] = i;
            for (int j = 1; j < word2.length() + 1; j++) {
                //保存原值 即下一个四格运算的dp[i-1][j-1]
                int pre = dp[j];
                //开始每4个格子做运算计算出右下角的值
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //第i个字符和第j个字符相等，则不需要操作，即和word1前i-1个字符 word2前j-1个字符  所需要的最小操作相等
                    dp[j] = temp;
                } else {
                    int min = Math.min(Math.min(dp[j], temp), dp[j - 1]);
                    dp[j] = min + 1;
                }
                //传给下一个四格运算
                temp = pre;
            }
        }
        return dp[word2.length()];
    }

}
