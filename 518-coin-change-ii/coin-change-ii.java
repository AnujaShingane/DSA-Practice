class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];

        for(int amt = 0 ; amt <= amount ; amt++){
            if(amt%coins[0]==0)prev[amt]= 1;
            else prev[amt]= 0;
        }

        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt <= amount ; amt++){
                int pick = 0;
                if(coins[i]<=amt)pick = cur[amt-coins[i]];
                int notpick = prev[amt];
                cur[amt] = notpick+pick;
            }
            prev = cur.clone();
        }

        return prev[amount];
    }
}