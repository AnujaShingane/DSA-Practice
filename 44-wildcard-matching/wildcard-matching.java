class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(s, p, n, m, dp);
    }

    // i = length of s prefix, j = length of p prefix (1-based sizes)
    private boolean solve(String s1, String s2, int i, int j, Boolean[][] dp) {
        // both empty -> match
        if (i == 0 && j == 0) return true;

        // pattern empty but text not -> no match
        if (j == 0) return false;

        // text empty -> pattern must be all '*'
        if (i == 0) {
            for (int k = 1; k <= j; k++) {
                if (s2.charAt(k - 1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];


        boolean ans;
        if (s2.charAt(j-1) == s1.charAt(i-1) || s2.charAt(j-1) == '?') {
            ans = solve(s1, s2, i - 1, j - 1, dp);
        } else if (s2.charAt(j-1) == '*') {
            // '*' matches empty  -> (i, j-1)
            // or matches one+    -> (i-1, j)
            ans = solve(s1, s2, i, j - 1, dp) || solve(s1, s2, i - 1, j, dp);
        } else {
            ans = false;
        }
        return dp[i][j] = ans;
    }
}