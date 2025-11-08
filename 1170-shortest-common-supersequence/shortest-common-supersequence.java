class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return printSuperseq(str1, str2);
    }

    public String printSuperseq(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // LCS table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct SCS using the LCS table
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // same char contributes once
                sb.append(s1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                // move up: take from s1
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                // move left: take from s2
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining chars (if any)
        while (i > 0) sb.append(s1.charAt(--i));
        while (j > 0) sb.append(s2.charAt(--j));

        return sb.reverse().toString();
    }
}