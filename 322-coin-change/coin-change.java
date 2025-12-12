class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];

        for(int amt = 0 ; amt <= amount ; amt++){
            if(amt%coins[0]==0)prev[amt]=amt/coins[0];
            else prev[amt]= (int)(1e9);
        }

        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt<=amount ; amt++){
                int nottake = prev[amt];
                int take = Integer.MAX_VALUE;
                if(amt>=coins[i])take = 1+cur[amt-coins[i]];
                cur[amt]=Math.min(nottake,take);
            }
            prev = cur.clone();
        }

        return (prev[amount]==1e9)?-1:prev[amount];
    }
}