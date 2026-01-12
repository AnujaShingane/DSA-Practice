class Solution {
    int max = 0;

    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        func(n, m, s1, s2, dp);
        return max;
    }

    public int func(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int val = 0;
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            val = 1 + func(i-1, j-1, s1, s2, dp);
            max = Math.max(max, val);
        } else {
            val = 0;
        }

        // must explore all cells
        func(i-1, j, s1, s2, dp);
        func(i, j-1, s1, s2, dp);

        return dp[i][j] = val;
    }
}
