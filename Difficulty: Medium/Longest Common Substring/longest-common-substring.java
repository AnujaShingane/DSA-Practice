import java.util.*;

class Solution {
    int ans; 

    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        ans = 0;

        // IMPORTANT: must explore all (i, j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                func(i, j, s1, s2, dp);
            }
        }

        return ans;
    }

    public int func(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + func(i - 1, j - 1, s1, s2, dp);
            ans = Math.max(ans, dp[i][j]); // Update global max
        } else {
            dp[i][j] = 0; // substring break
        }

        return dp[i][j];
    }
}
