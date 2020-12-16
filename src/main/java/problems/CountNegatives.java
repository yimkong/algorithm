package problems;

/**
 * author yg
 * description
 * 给你一个m* n的矩阵grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回grid中 负数 的数目。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 *
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 *
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 *
 * 输入：grid = [[-1]]
 * 输出：1
 * 
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/12/16
 */
public class CountNegatives {

    //空间复杂度O(1) O(n) TODO?
    //正向思考
    public static int countNegatives(int[][] grid) {
        int x = -1;//打横的第一个负数
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (x == 0) {
                count += (grid.length - i) * grid[i].length;
                break;
            }
            for (int j = 0; j < grid[i].length; j++) {
                //更新记录负数下标
                if (grid[i][j] < 0) {
                    if (x == -1) {
                        x = j;
                    } else if (j < x) {
                        x = j;
                    }
                }
                //到了这个负数下标后面肯定都是负数，所以直接跳过
                if (x != -1 && j >= x) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }

    //负向思考
    public static int countNegatives1(int[][] grid) {
        int num = 0, m = (int) grid[0].length, pos = (int) grid[0].length - 1;
        for (int[] x : grid) {
            int i;
            for (i = pos; i >= 0; --i) {//从尾部开始找正数，只要找到正数，则右边的都是负数
                if (x[i] >= 0) {
                    if (i + 1 < m) {//防止数组超标
                        num = num + (m - i - 1);//计算负数
                    }
                    break;
                }
            }
            if (i == -1) {
                num += m;
                pos = -1;//标记为-1，代表只要找到第一个数是负数的，之后都不在循环，因为上面循环判断 i>=0不满足
            }
        }
        return num;

    }
}
