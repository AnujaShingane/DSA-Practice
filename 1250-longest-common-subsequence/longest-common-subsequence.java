class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }

        return func(n,m,text1,text2,dp);
    }

    public int func(int i , int j, String s1, String s2, int[][] dp) {
        if(i==0 || j==0)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        
        if(s1.charAt(i-1)==s2.charAt(j-1))return dp[i][j]=1+func(i-1,j-1,s1,s2,dp);
        return dp[i][j]=Math.max(func(i,j-1,s1,s2,dp),func(i-1,j,s1,s2,dp));
    }
}