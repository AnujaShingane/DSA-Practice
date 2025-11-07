import java.util.*;

class Solution {
    public List<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        // 1) LCS length DP
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 2) Reconstruct all LCS with memoization
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> all = dfs(s1, s2, n, m, dp, memo);

        // 3) Sort and return (remove empty if present)
        TreeSet<String> sorted = new TreeSet<>(all);
        sorted.remove("");
        return new ArrayList<>(sorted);
    }

    private Set<String> dfs(String s1, String s2, int i, int j,
                            int[][] dp, Map<String, Set<String>> memo) {
        if (i == 0 || j == 0) {
            // base: empty subsequence
            return new HashSet<>(Collections.singleton(""));
        }

        String key = i + "|" + j;
        if (memo.containsKey(key)) return memo.get(key);

        Set<String> ans = new HashSet<>();

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // character is part of every LCS from (i-1, j-1)
            for (String tail : dfs(s1, s2, i - 1, j - 1, dp, memo)) {
                ans.add(tail + s1.charAt(i - 1));
            }
        } else {
            // move only along directions that keep the LCS length maximal
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                ans.addAll(dfs(s1, s2, i - 1, j, dp, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                ans.addAll(dfs(s1, s2, i, j - 1, dp, memo));
            }
        }

        memo.put(key, ans);
        return ans;
    }
}
