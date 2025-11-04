class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }

        return func(n-1,m-1,text1,text2,dp);
    }

    public int func(int ind1,int ind2,String str1,String str2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1 + func(ind1-1,ind2-1,str1,str2,dp);
        }

        return dp[ind1][ind2] = Math.max(func(ind1-1,ind2,str1,str2,dp),func(ind1,ind2-1,str1,str2,dp));
    }
}