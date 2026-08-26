class Solution {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,target,arr,dp);
    }
    
    static int func(int ind,int target,int[] arr,int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2; // Can pick or skip 0
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)return dp[ind][target];

        int take = 0;
        if(target>=arr[ind]) take = func(ind-1,target-arr[ind],arr,dp);
        int nottake = func(ind-1,target,arr,dp);

        return dp[ind][target] = take + nottake;
    }
}