package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2022/4/26
 * desc
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem169 {

    //时间O(n) 空间O(n)
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            map.put(nums[i], map.computeIfAbsent(nums[i], x -> 0)+1);
            if(map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }

    //O(nlogn) 空间O(logn)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    //时间O(n) 空间O(1)
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0) candidate = nums[i];
            count += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }


}
