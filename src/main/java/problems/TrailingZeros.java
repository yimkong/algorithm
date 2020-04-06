package problems;

/**
 * author yg
 * description
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * 计算n阶乘结果里0的个数
 * 例如 输入11 输出为2  因为11的阶乘等于39916800
 * date 2020/4/6
 */
public class TrailingZeros {
    //思考：阶乘计算里,把所有数分解为最小因子后发现,只有2*5才会计算出0,因此2*5的对数等于0的个数
    //在阶乘分解后的乘法计算里,例如 11!=1*2*3*4*5*6*7*8*9*10*11=1*2*3*4*5*2*3*7*2*2*2*9*2*5*11=2的5次方*5的2次方*...
    //因此直接将n除以5是计算包含5的n次幂的个数
    public static long compute(long n) {
        long ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }

}
