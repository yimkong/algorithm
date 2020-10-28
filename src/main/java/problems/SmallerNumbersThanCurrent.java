package problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * author yg
 * description
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * date 2020/10/28
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ints[i] = count;
        }
        return ints;
    }

    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        int[][] ints = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {//记录数字以及下标
            ints[i][0] = nums[i];
            ints[i][1] = i;
        }
        Arrays.sort(ints, Comparator.comparingInt(o -> o[0]));
        int[] res = new int[nums.length];
        int pre = 0;
        for (int i = 0; i < ints.length; i++) {//有可能有多个数字相等，所以要取左边的数字，左边数字的下标为小于该数字的个数
            if (i != 0 && ints[i][0] == ints[i - 1][0]) {
                res[ints[i][1]] = pre;
            } else {
                res[ints[i][1]] = i;//取排序后的下标，代表有多少个数小于当前数
                pre = i;
            }
            //另一种逻辑
//            if (prev == -1 || data[i][0] != data[i - 1][0]) {//只有当前数字和前一个数字不相等的时候，才需要更新pre
//                prev = i;
//            }
//            ret[data[i][1]] = prev;

        }
        return res;
    }

}
