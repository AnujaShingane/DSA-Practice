class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i = 0 ; i <= n ; i++)curr[0]=i;
        for(int j = 0 ; j <= m ; j++)prev[j]=j;

        for(int i = 1 ; i <= n ; i++){
            curr[0]=i;
            for(int j = 1 ; j <= m ; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }

                else curr[j]=1+Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
            }
            prev =curr.clone();
        }
        return prev[m];
    }

    // public int func(int i,int j , String s1, String s2,int[][] dp) {
    //     if(i==0)return j;
    //     if(j==0)return i;

    //     if(dp[i][j] != -1)return dp[i][j];

    //     if(s1.charAt(i-1)==s2.charAt(j-1)){
    //         return dp[i][j]=func(i-1,j-1,s1,s2,dp);
    //     }

    //     return dp[i][j]=1+Math.min(func(i,j-1,s1,s2,dp),Math.min(func(i-1,j,s1,s2,dp),func(i-1,j-1,s1,s2,dp)));
    // }
}