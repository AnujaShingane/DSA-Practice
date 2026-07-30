class Solution {
    HashMap<Integer,Integer> map;
    public boolean canCross(int[] stones) {
        if(stones[1]!=1)return false;
        int n = stones.length;
        map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(stones[i],i);
        }
        Boolean[][] dp = new Boolean[n][n-1];

        return func(1,1,stones,dp);
    }

    public boolean func(int ind,int last,int[] stones,Boolean[][] dp) {
        if(ind==stones.length-1){
            return true;
        }
        if(dp[ind][last]!=null){
            return dp[ind][last];
        }

        for(int jump = last-1 ; jump <= last+1 ; jump++){
            if(jump<=0)continue;
            int nextJump = jump + stones[ind];

            if(map.containsKey(nextJump)){
                if(func(map.get(nextJump),jump,stones,dp))return true;
            }
        }

        return dp[ind][last] = false;
    }
}