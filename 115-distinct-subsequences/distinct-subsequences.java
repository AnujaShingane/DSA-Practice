class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        prev[0] = 1;

        for(int i = 0 ; i <= n ; i++)curr[0]=1;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = prev[j-1]+prev[j];
                }
                else curr[j]=prev[j];
            }
            prev = curr.clone();
        }
        return prev[m];
    }

    // public int func(String s1, String s2,int i , int j,int[][] dp) {
    //     if(i==0)return 0;
    //     if(j==0)return 1;

    //     if(dp[i][j] != -1)return dp[i][j];

    //     if(s1.charAt(i-1)==s2.charAt(j-1)){
    //         return dp[i][j] = func(s1,s2,i-1,j-1,dp)+func(s1,s2,i-1,j,dp);
    //     }
    //     return dp[i][j]=func(s1,s2,i-1,j,dp);
    // }
}