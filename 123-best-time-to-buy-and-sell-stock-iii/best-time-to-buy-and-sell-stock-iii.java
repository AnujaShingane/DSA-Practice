class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row,-1);
            }
        }

        return func(0,1,prices,dp,0);
    }

    public int func(int i , int j , int[] prices,int[][][] dp,int cnt) {
        if(i==prices.length)return 0;
        if(dp[i][j][cnt] != -1)return dp[i][j][cnt];

        int profit = 0;
    
        if(j==1 && cnt<2)profit = Math.max((-prices[i]+func(i+1,0,prices,dp,cnt)),(0+func(i+1,1,prices,dp,cnt)));
        else if(j==0 && cnt<2) profit = Math.max((prices[i]+func(i+1,1,prices,dp,cnt+1)),(0+func(i+1,0,prices,dp,cnt)));
        return dp[i][j][cnt] = profit;
    }
}