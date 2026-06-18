import java.util.Arrays;

class Solution {

    long[][] dp;

    public long maxTotal(int[] nums, String s) {

        int n = nums.length;

        dp = new long[n][2];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(n - 1, 0, nums, s);
    }

    long func(int i, int nextMoved, int[] nums, String s) {

        if (i < 0) {
            return 0;
        }

        if (dp[i][nextMoved] != -1) {
            return dp[i][nextMoved];
        }

        // No token at i
        if (s.charAt(i) == '0') {

            long gain = (nextMoved == 1 ? nums[i] : 0);

            return dp[i][nextMoved] =
                    gain + func(i - 1, 0, nums, s);
        }

        // Option 1: token stays at i
        long stay =
                nums[i] +
                func(i - 1, 0, nums, s);

        // Option 2: token moves to i-1
        long move =
                (nextMoved == 1 ? nums[i] : 0) +
                func(i - 1, 1, nums, s);

        return dp[i][nextMoved] =
                Math.max(stay, move);
    }
}