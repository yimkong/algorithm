package problems;

/**
 * author yg
 * description
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * <p>
 * 完成所有替换操作后，请你返回这个数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/12/7
 */
public class ReplaceElements {
    public static int[] replaceElements(int[] arr) {
        int[] record = {-1, -1};
        findAndSetMax(arr, record, -1);
        for (int i = 0; i < arr.length; i++) {
            if (i == record[0]) {
                //find again
                findAndSetMax(arr, record, i);
            }
            arr[i] = record[1];
        }
        return arr;
    }

    private static void findAndSetMax(int[] arr, int[] record, int start) {
        record[1] = -1;
        if (start == arr.length - 1) {
            record[0] = arr.length - 1;
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > record[1]) {
                record[0] = i;
                record[1] = arr[i];
            }
        }
    }
//reverse the process, record the max value on right side dynamically
    public static int[] replaceElements1(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            arr[i] = max;
            max = Math.max(max, curr);
        }
        return arr;
    }
}
