class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if(arr[0]<=sum)dp[0][arr[0]] = true;
        
        for(int i = 1 ; i < n ; i++){
            for(int s = 0 ; s <= sum ; s++){
                boolean take = false;
                if(arr[i]<=s)take = dp[i-1][s-arr[i]];
                boolean nottake = dp[i-1][s];
                
                dp[i][s] = take || nottake;
            }
        }
        
        return dp[n-1][sum];
    }
}