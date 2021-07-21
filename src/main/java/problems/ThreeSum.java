package problems;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeSum().threeSum(a);
        System.err.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        //双指针解法，时间复杂度为O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//重复的排除
            int k = i + 1, j = nums.length - 1;
            while (j > k) {
                int result = nums[i] + nums[j] + nums[k];
                if (result == 0) {
                    ArrayList<Integer> objects = new ArrayList<>();
                    resultList.add(objects);
                    objects.add(nums[i]);
                    objects.add(nums[k]);
                    objects.add(nums[j]);
                    while (j > k && nums[j - 1] == nums[j]) j--; //重复的排除
                    while (j > k && nums[k + 1] == nums[k]) k++;//重复的排除
                    j--;
                    k++;
                } else if (result > 0) {
                    j--;//总和减少
                } else {
                    k++;//总和增加
                }

            }
        }
        return new ArrayList<>(resultList);
    }
}
