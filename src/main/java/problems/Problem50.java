package problems;

/**
 * 2022/3/13
 * desc
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem50 {
    public double myPow(double x, int n) {
        return n < 0 ? 1/ helper(x, -n) : helper(x, n);
    }

    public double helper(double x, int n){
        double res = 1;
        while(n != 0){
            if(n % 2 != 0) res *= x; //神奇的一步，如果n是奇数的时候，一开始就乘一个保存在res里面，最后当n除到1的时候，把x乘进去，例如 x=3,n=5, 那么在这里第一步先存一个3，然后当成3的4次方来算
            x *= x;
            n /= 2;// 例如x=3,n=8时，那么就是 x=3*3,n=4，，下一次循环则是 x=9*9 n=2，再下一次 x=81*81,n=1，再下一次 (保存81*81到res）81*81 的平方，n=0,循环结束，总的来说，n能被2除几次到1，则在这里x的平方几次，最后n=1时记录结果
        }
        return res;
    }

    //该方法用来求x的n次方是多少
    double recursiveHelper(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double y = recursiveHelper(x, n/2);// x=3,n=5 时，求3的2次方 ,x=3,n=4时，求3的2次方
        return n % 2 == 0 ? y* y  :y * y * x; // 3的2次方的结果再乘以3的2次方，是3的4次方，这时候如果是奇数则再补乘一个当前栈里面的3
    }
}
