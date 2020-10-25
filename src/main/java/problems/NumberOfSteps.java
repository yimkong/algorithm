package problems;

/**
 * author yg
 * description
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 * <p>
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 * <p>
 * 输入：num = 123
 * 输出：12
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date 2020/10/25
 */
public class NumberOfSteps {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }

    //位运算 32位 二进制 => 2的32次方 =  2的四次方的八次方 = 16的八次方 表示 0xffffffff
    public int numberOfSteps1(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num & 1) == 1 ? num & -2 : num >> 1;//num & 1 是为了得到最后的末位二进制,为1则是奇数不为1则是偶数，num & -2是为了去掉末位1
            // -2二进制表示：11111...11110 转为十六进制（数有几个1，每4个1位一个f） 0xfffffffe
        }
        return count;
    }
}
