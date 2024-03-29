package problems;

import java.util.stream.IntStream;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1588 {
    //当子数组为奇数数组时，扣去当前i占据一位，那么左边和右边的个数，要么都为奇数，要么都为偶数，分两种情况考虑，分别计算俩边的奇偶的个数
    //其实就是计算每个数在各个子数组可能出现的次数，然后就可以知道该数在子数组的总和
    //复杂度为O(n)
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, sum = 0;
        for(int i = 0; i< n; i++){
            int leftCount = i,rightCount = n - i -1;
            //俩边都是奇数
            int oddL = (leftCount+1)/2, oddR = (rightCount+1)/2; // 每个奇数的个数等于后一个偶数除以2
            //俩边都是偶数
            int evenL = leftCount/2 + 1,evenR = rightCount/2 + 1; //每个偶数的个数等于 该数除以2加1是因为要算上0，不算0的话就不用+1，因为会自动约去奇数的余数
            sum += arr[i] * (oddL * oddR + evenL * evenR);
        }
        return sum;
    }

    //暴力枚举，复杂度为O(n^3)
    public int sumOddLengthSubarrays1(int[] arr) {
        int sum = 0, n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length+=2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    //前缀和，复杂度O(n^2),通过该方式可以随便求某一段连续子数组的累和，例如求 n 下标到 m 下标的累和，则是arr[m+1]-arr[n]
    public int sumOddLengthSubarrays2(int[] arr) {
        int[] record = new int[arr.length + 1];//每个index代表是0 到 index-1 的数组数的和
        for (int i = 0; i < arr.length; i++) {
            record[i+1] = arr[i] + record[i];
        }
        int sum = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int length = 1; start + length <= arr.length; length += 2) {
                int end = start + length - 1 ;
                sum += record[end+1] -record[start];
            }
        }
        return sum;
    }

}
