class Solution {
    static int mod = (int) (1e9 + 7);
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        int totalSum=0;
        for(int i = 0 ; i < n ; i++)totalSum+=arr[i];
        
        if(totalSum < diff || (totalSum + diff) % 2 != 0)
            return 0;
            
        int target = (totalSum+diff)/2;
        
        int[][] dp = new int[n][target+1];    
        for(int[] ar : dp)Arrays.fill(ar,-1);
        
        return func(n-1,target,diff,arr,dp);
    }
    
    public int func(int i,int target,int diff,int[] arr,int[][] dp) {
        if(i==0){
            if(target==0 && arr[0]==0)return 2;
            if(target==0 || target==arr[0])return 1;
            return 0;
        }
        
        if(dp[i][target]!=-1)return dp[i][target];
        
        int take = 0;
        if(target>=arr[i])take = func(i-1,target-arr[i],diff,arr,dp);
        
        int nottake = func(i-1,target,diff,arr,dp);
        
        return dp[i][target]=(take+nottake)%mod;
    }
}
