import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    // Count of subsets with sum = target
    public int perfectSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // empty subset

        for (int x : nums) {
            if (x == 0) {
                // zero doubles all existing ways: pick or not-pick
                for (int s = 0; s <= target; s++) {
                    dp[s] = (dp[s] * 2) % MOD;
                }
            } else {
                // iterate descending to use each item once
                for (int s = target; s >= x; s--) {
                    dp[s] = (dp[s] + dp[s - x]) % MOD;
                }
            }
        }
        return dp[target];
    }
}
