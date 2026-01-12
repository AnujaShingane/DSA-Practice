class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }


        return func(n,m,text1,text2,dp);
    }

    public int func(int i,int j,String text1, String text2,int[][] dp) {
        int ans = 0;

        if(i==0 || j == 0)return 0;//dp[][]=0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(text1.charAt(i-1)==text2.charAt(j-1)){
            ans = 1+func(i-1,j-1,text1,text2,dp);
        }else{
            ans = Math.max(func(i-1,j,text1,text2,dp),func(i,j-1,text1,text2,dp));
        }

        return dp[i][j]=ans;
    }
}