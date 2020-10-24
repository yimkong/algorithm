package problems;

/**
 * author yg
 * description
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 * 示例 1：
 * <p>
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
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/10/24
 */
public class SumOddLengthSubarrays {

    //时间复杂度 O(n^2)
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i; j < arr.length; j++) {
                if (count++ % 2 == 0) {
                    continue;
                }
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    /**
     * 时间复杂度 O(n)
     * * odd奇数，even偶数
     * * 对于每个元素i(数组中下标为i)来说，要构成奇数长度的子数组
     * 即 i左边的元素个数left+i本身自己一个+右边元素的个数right=奇数
     * 即 left+right=偶数
     * * 满足left+right=偶数就只有两种情况
     * 1. 奇数+奇数=偶数
     * 2. 偶数+偶数=偶数
     * * 1. 所以只需要求得i左边可以选择奇数长度的可能有多少种，即left_odd,同样求右边奇数right_odd
     * 就可以求出策略1有多少种可能
     * 2. 所以只需要求得i左边可以选择偶数长度的可能有多少种，即left_even,同样求右边偶数right_even
     * 就可以求出策略1有多少种可能，注意0也算选择的一种可能
     * * 即元素i在所有奇数长度子数组出现的次数总和是
     * left_odd*right_odd+left_even*right_even
     * * 元素i左边元素共有i个，右边元素共有siz-i-1个
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays1(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {//找出每个数可存在的奇数数组的次数*数字=该数字的最终计算和
            int left = i + 1;//左边可选择长度,如果i是0，则代表左边有一个选择（就是不选）
            int right = arr.length - i,//右边的可选择长度，也要考虑长度为0的数组，例如[3,9,4] 在i=0的时候，右边的可选择长度为0，1，2，3
                    left_even = (left + 1) / 2,//左边的偶数长度的数组的选择方案
                    right_even = (right + 1) / 2,//右边的偶数长度的数组的选择方案
                    left_odd = left / 2,//左边的奇数长度的数组的选择方案
                    right_odd = right / 2;//右边的奇数长度的数组选择方案
            sum += (left_even * right_even + left_odd * right_odd) * arr[i];//元素i在所有奇数长度子数组出现的次数总和是
        }
        return sum;
    }

}
