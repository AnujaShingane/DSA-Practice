class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrays(nums,goal) - numSubarrays(nums,goal-1);
    }

    public int numSubarrays(int[] nums, int goal) {
        int n = nums.length;
        int l = 0 , r = 0;
        int cnt = 0;
        int sum = 0;
        if(goal < 0) return 0;

        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            if(sum <= goal){
                cnt += r-l+1;
            }
            r++;
        }
        return cnt;
    }
}