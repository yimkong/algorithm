package dynamicprograme;

/**
 * 有只青蛙，一次可以跳一格阶梯也可以跳俩格
 * 问：跳到n格阶梯有几种跳法
 *
 */
public class FrogJump {
    public static void main(String[] args) {
        System.err.println(start(5));
    }

    public static int start(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            //n格阶梯的可能性等于 n-1和n-2阶梯可能性相加 因为青蛙可能从n-1格跳到n格 也可能从n-2格跳到n格，即到达n格阶梯的可能性相加
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }
}
