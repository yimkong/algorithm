package problems;

/**
 * https://leetcode.cn/problems/valid-sudoku/description/
 */
public class Problem36 {
    //复杂度O(n)
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] bucket = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1; //'1' to '9'
                    //start count for row / colomn / 3*3 ，3种情况
                    row[i][index]++;
                    col[j][index]++;
                    bucket[i / 3][j / 3][index]++;//每个3*3只需要记录一个左上角的格子位置
                    //每种条件不能有重复的数字
                    if (row[i][index] > 1 || col[j][index] > 1 || bucket[i / 3][j / 3][index] > 1) return false;

                }
            }
        }
        return true;
    }

}
