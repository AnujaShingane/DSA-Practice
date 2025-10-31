// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[][] dp = new int[n][4];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }
        
        return func(n-1,3,arr,dp);
    }
    
    public int func(int day,int last,int[][] arr,int[][] dp){ 
        if(day==0){
            int maxi = 0;
            for(int i = 0 ; i < 3 ; i++){
                if(i!=last){
                    maxi = Math.max(maxi,arr[day][i]);
                }
            }
            return maxi;
        }
        
        if(dp[day][last] != -1)return dp[day][last];
        
        int maxi = 0;
        
        for(int i = 0 ; i < 3 ; i++){
            if(i!=last){
                int score  = arr[day][i]+func(day-1,i,arr,dp);
                maxi = Math.max(score,maxi);
            }
        }
        return dp[day][last] = maxi;
    }
}