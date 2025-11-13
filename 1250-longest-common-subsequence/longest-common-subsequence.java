class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))cur[j]=1+prev[j-1];
                else cur[j]=Math.max(cur[j-1],prev[j]);
            }
            prev = cur.clone();
        }

        return cur[m];
    }

    // public int func(int i , int j, String s1, String s2, int[][] dp) {
    //     if(i==0 || j==0)return 0;
    //     if(dp[i][j] != -1)return dp[i][j];
        
    //     if(s1.charAt(i-1)==s2.charAt(j-1))return dp[i][j]=1+func(i-1,j-1,s1,s2,dp);
    //     return dp[i][j]=Math.max(func(i,j-1,s1,s2,dp),func(i-1,j,s1,s2,dp));
    // }
}