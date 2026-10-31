package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlices2Subsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> numToIndices = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            numToIndices.putIfAbsent((long) nums[i], new ArrayList<>());
            numToIndices.get((long) nums[i]).add(i);
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j) {
                final long target = nums[j] * 2L - nums[i];
                if (numToIndices.containsKey(target))
                    for (final int k : numToIndices.get(target))
                        if (k < j)
                            dp[i][j] += (dp[j][k] + 1);
                ans += dp[i][j];
            }
        return ans;
    }
}
