class Solution {
    int maxprofit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1; j++){
                for(int k = 0 ; k <= 1 ; k++){
                    if(j==1){
                        dp[i][1][k] = Math.max((-prices[i] + dp[i+1][0][k]), (0+dp[i+1][1][k]));
                    }else{
                        dp[i][0][k] = Math.max((prices[i] + dp[i+1][1][k+1]), (0+dp[i+1][0][k]));
                    }
                }
            }
        }

        return dp[0][1][0];
    }
}