package problems;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];
        //双指针 复杂度O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(tempSum - target) < Math.abs(minSum - target))
                    minSum = tempSum;
                if (tempSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] i = {-3, -2, -5, 3, -4 - 1};
        System.err.println(new ThreeSumClosest().threeSumClosest(i, 1));
    }
}
