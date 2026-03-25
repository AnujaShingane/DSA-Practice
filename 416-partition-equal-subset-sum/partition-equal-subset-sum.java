class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }
        int target = sum/2;
        dp = new Boolean[n][target+1];

        // Step 1: If sum is odd → not possible
        if(sum % 2 != 0) return false;

        // Step 2: Target = sum / 2
        return f(n - 1, sum / 2, nums);
    }
    
    public boolean f(int i, int target, int[] arr){
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        if(dp[i][target]!=null)return dp[i][target];

        boolean notTake = f(i - 1, target, arr);

        boolean take = false;
        if(arr[i] <= target)
            take = f(i - 1, target - arr[i], arr);

        return dp[i][target] = take || notTake;
    }
}