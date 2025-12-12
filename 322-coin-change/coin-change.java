class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        if (amount == 0) return 0;
        if (n == 0) return -1;

        for(int amt = 0 ; amt<=amount ; amt++){
            if(amt%coins[0]==0)dp[0][amt]=amt/coins[0];
            else dp[0][amt]=(int)1e9;
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt <= amount ; amt++){
                int nottake = dp[i-1][amt];
                int take = Integer.MAX_VALUE;
                if(amt>=coins[i])take = 1+dp[i][amt-coins[i]];

                dp[i][amt]=Math.min(nottake,take);
            }
        }

        return (dp[n-1][amount]==1e9)?-1:dp[n-1][amount];
    }
}