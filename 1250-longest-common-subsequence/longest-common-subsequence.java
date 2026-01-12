class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int ans = 0;

        for(int i = 0 ; i <= n ; i++)dp[i][0]=0;
        for(int i = 0 ; i <= m ; i++)dp[0][i]=0;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    ans = 1+dp[i-1][j-1];
                }else{
                    ans = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                dp[i][j]=ans;
            }
        }

        return dp[n][m];
    }

    public int func(int i,int j,String text1, String text2,int[][] dp) {
        int ans = 0;

        if(i==0 || j == 0)return 0;//dp[0][j]=0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(text1.charAt(i-1)==text2.charAt(j-1)){
            ans = 1+func(i-1,j-1,text1,text2,dp);
        }else{
            ans = Math.max(func(i-1,j,text1,text2,dp),func(i,j-1,text1,text2,dp));
        }

        return dp[i][j]=ans;
    }
}