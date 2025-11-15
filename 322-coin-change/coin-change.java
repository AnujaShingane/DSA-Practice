class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int amt = 0 ; amt <= amount ; amt++){
            if(amt%coins[0] == 0)dp[0][amt] = amt/coins[0];
            else dp[0][amt] = (int)1e9;
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= amount ; j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MAX_VALUE;
                if(j>=coins[i]){
                    pick = 1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(notPick,pick);
            }
        }

        int ans = dp[n-1][amount];
        if(ans >= (int)1e9)return -1;
        else return ans;
    }
}