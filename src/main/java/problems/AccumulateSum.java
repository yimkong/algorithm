package problems;

/**
 * author yg
 * description
 * date 2020/10/21
 */
public class AccumulateSum {
    public static int subtractProductAndSum(int n) {
        int accumulate = 1;
        int sum = 0;
        while (n != 0) {
            int i1 = n % 10;
            accumulate *= i1;
            sum += i1;
            n = n / 10;
        }
        return accumulate - sum;
    }
}
