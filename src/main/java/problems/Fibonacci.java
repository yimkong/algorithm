package problems;

/**
 * author yg
 * description 斐波那契计算
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)
 * <p>
 * date 2020/3/22
 */
public class Fibonacci {
//此种算法时间复杂度O(n),空间复杂度为O(1)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int a = 1, b = 1, last = 0;
        for (int i = 3; i <= n; i++) {
            last = a + b;
            a = b;
            b = last;
        }
        return last;
    }
}
