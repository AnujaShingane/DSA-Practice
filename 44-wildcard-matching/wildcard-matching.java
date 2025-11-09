class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        // base: empty vs empty
        dp[0][0] = true;

        // base: empty string vs pattern prefix
        for (int j = 1; j <= m; j++) {
            dp[0][j] = (p.charAt(j - 1) == '*') ? dp[0][j - 1] : false; // <-- fix
        }
        // base: non-empty string vs empty pattern -> false
        for (int i = 1; i <= n; i++) dp[i][0] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' matches empty (dp[i][j-1]) or one/more (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // <-- no early return
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
