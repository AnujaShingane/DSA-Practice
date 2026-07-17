class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int tS = 0;
        for(int i = 0 ; i < n ; i++){
            tS+=stones[i];
        }

        Boolean[][] dp = new Boolean[n][tS+1];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= tS/2 ; i++){
            if(func(n-1,i,stones,dp)){
                min = Math.min(min,Math.abs(2*i-tS));
            }
        }

        return min;
    }

    public boolean func(int ind,int target,int[]stones,Boolean[][] dp) {
        if(target==0)return true;
        if(ind==0){
            if(target==stones[ind])return true;
            else return false;
        }
        if(dp[ind][target]!=null)return dp[ind][target];

        boolean take = false;
        if(target>=stones[ind]) take = func(ind-1,target-stones[ind],stones,dp);
        boolean nottake = func(ind-1,target,stones,dp);

        return dp[ind][target] = take || nottake;
    }
}