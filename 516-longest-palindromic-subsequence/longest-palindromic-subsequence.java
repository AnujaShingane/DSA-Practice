class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        return lcs(s,s2);
    }

    public int lcs(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        //int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                    //ans = Math.max(ans,dp[i][j]);
                }else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}