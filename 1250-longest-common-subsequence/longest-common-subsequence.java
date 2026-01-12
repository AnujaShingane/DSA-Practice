class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        // for(int i = )

        return func(n-1,m-1,text1,text2,dp);
    }

    public int func(int i,int j,String text1, String text2,int[][] dp) {
        int ans = 0;

        if(i<0 || j < 0)return 0;//dp[][]=0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            ans = 1+func(i-1,j-1,text1,text2,dp);
        }else{
            ans = Math.max(func(i-1,j,text1,text2,dp),func(i,j-1,text1,text2,dp));
        }

        return dp[i][j]=ans;
    }
}