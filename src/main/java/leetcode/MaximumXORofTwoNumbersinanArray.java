package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        if (maxNum == 0)
            return 0;
        final int maxBit = (int) (Math.log(maxNum) / Math.log(2));
        int ans = 0;
        int prefixMask = 0;
        for (int i = maxBit; i >= 0; --i) {
            prefixMask |= 1 << i;
            Set<Integer> prefixes = new HashSet<>();
            for (final int num : nums)
                prefixes.add(num & prefixMask);
            final int candidate = ans | 1 << i;
            for (final int prefix : prefixes)
                if (prefixes.contains(prefix ^ candidate)) {
                    ans = candidate;
                    break;
                }
        }
        return ans;
    }
}
