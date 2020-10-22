package problems;

/**
 * author yg description 1389. 按既定顺序创建目标数组 给你两个整数数组 nums 和
 * index。你需要按照以下规则创建目标数组：
 * <p>
 * 目标数组 target 最初为空。 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i]
 * 处插入值 nums[i] 。 重复上一步，直到在 nums 和 index 中都没有要读取的元素。 请你返回目标数组。
 * <p>
 * 题目保证数字插入位置总是存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1] 输出：[0,4,1,3,2] 解释： nums index
 * target 0 0 [0] 1 1 [0,1] 2 2 [0,1,2] 3 2 [0,1,3,2] 4 1 [0,4,1,3,2] 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0] 输出：[0,1,2,3,4] 解释： nums index
 * target 1 0 [1] 2 1 [1,2] 3 2 [1,2,3] 4 3 [1,2,3,4] 0 0 [0,1,2,3,4] 示例 3：
 * <p>
 * 输入：nums = [1], index = [0] 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, index.length <= 100 nums.length == index.length 0 <=
 * nums[i] <= 100 0 <= index[i] <= i
 * <p>
 * date 2020/10/22
 */
public class CreateTargetArray {

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            for (int j = index.length - 1; j > index[i]; j--) {//从末尾开始赋值
                res[j] = res[j - 1];
            }
        }
        return res;
    }

    public static int[] createTargetArray1(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            int last = res[index[i]];
            int cur;
            //从下一个值开始往后移动数字
            for (int j = index[i] + 1; j < index.length; j++) {
                //把当前值保存起来以便下一个循环使用
                cur = res[j];
                //上一个值赋值当前值
                res[j] = last;
                //当前值在下一个循环变成上一个值
                last = cur;
            }
            res[index[i]] = nums[i];
        }
        return res;
    }

}
