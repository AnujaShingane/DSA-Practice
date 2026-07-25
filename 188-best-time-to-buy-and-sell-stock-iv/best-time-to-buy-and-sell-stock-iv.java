class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1; j++){
                for(int z = 0 ; z <= k-1 ; z++){
                    if(j==1){
                        dp[i][1][z] = Math.max((-prices[i] + dp[i+1][0][z]), (0+dp[i+1][1][z]));
                    }else{
                        dp[i][0][z] = Math.max((prices[i] + dp[i+1][1][z+1]), (0+dp[i+1][0][z]));
                    }
                }
            }
        }

        return dp[0][1][0];
    }
}