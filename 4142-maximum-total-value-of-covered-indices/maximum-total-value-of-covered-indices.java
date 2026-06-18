class Solution {
    long[][] dp;
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        dp = new long[n][2];
        for(long[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(n-1,0,s,nums);
    }

    public long func(int ind,int nexttoken,String s,int[] nums) {
        if(ind<0)return 0;
        if(dp[ind][nexttoken]!=-1)return dp[ind][nexttoken];

        if(s.charAt(ind)=='0'){
            long gain = (nexttoken==1) ? nums[ind] : 0;
            return dp[ind][nexttoken] = gain + func(ind-1,0,s,nums);
        }

        long stay = nums[ind] + func(ind-1,0,s,nums);

        long move = ((nexttoken==1) ? nums[ind] : 0 ) + func(ind-1,1,s,nums);

        return dp[ind][nexttoken] = Math.max(stay,move);
    }
}