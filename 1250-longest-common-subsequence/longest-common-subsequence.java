class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n,m,text1,text2,dp);
    }

    public int func(int ind1,int ind2,String s1,String s2,int[][] dp) {
        if(ind1==0 || ind2==0)return 0;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
            return 1+func(ind1-1,ind2-1,s1,s2,dp);
        }

        return dp[ind1][ind2]=Math.max(func(ind1-1,ind2,s1,s2,dp),func(ind1,ind2-1,s1,s2,dp));
    }
}