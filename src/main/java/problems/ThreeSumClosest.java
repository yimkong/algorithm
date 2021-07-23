package problems;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];
        //双指针 复杂度O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(tempSum - target) < Math.abs(minSum - target))
                    minSum = tempSum;
                if (tempSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] i = {-3, -2, -5, 3, -4 - 1};
        System.err.println(new ThreeSumClosest().threeSumClosest(i, 1));
    }
}
