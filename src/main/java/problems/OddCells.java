package problems;

import dataStructure.HashMap;

import java.util.Map;

/**
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddCells {
    public static int oddCells(int n, int m, int[][] indices) {
        Map<String, Integer> record = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            for (int j = 0; j < m; j++) {
                String key = genKey(row, j);
                record.putIfAbsent(key, 0);
                record.put(key, record.get(key) + 1);
            }
            for (int j = 0; j < n; j++) {
                String key = genKey(j, col);
                record.putIfAbsent(key, 0);
                record.put(key, record.get(key) + 1);
            }
        }
        long count = record.entrySet().stream().filter(x -> x.getValue() % 2 == 1).count();
        return (int) count;
    }

    //思想为分开思考，行单独计算和列单独计算，最后合并为一个矩阵
    public static int oddCells2(int n, int m, int[][] indices) {
        //下标为第几行,对应的value为奇数还是偶数
        int[] row = new int[n];
        int[] col = new int[m];

        for (int[] item : indices) {
            //使最终奇数为1 偶数为0   异或：相同为0不同为1
            row[item[0]] ^= 1;
            col[item[1]] ^= 1;
        }

        int rowNum = 0, colNum = 0;

        for (int i : row) {
            if (i == 1) {
                rowNum++;
            }
        }

        for (int i : col) {
            if (i == 1) {
                colNum++;
            }
        }
//剩下的都是奇数行和奇数列，去除行和列的重复项（因为奇数加奇数等于偶数）
        return rowNum * m + colNum * n - rowNum * colNum * 2;
    }

    private static String genKey(int row, int col) {
        return row + "_" + col;
    }
}
