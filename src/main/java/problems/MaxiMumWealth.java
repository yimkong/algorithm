package problems;

import java.util.stream.IntStream;

/**
 * author yg
 * description
 * date 2020/11/30
 */
public class MaxiMumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = IntStream.of(accounts[i]).sum();
            max = Math.max(max, sum);
        }
        return max;
    }
}
