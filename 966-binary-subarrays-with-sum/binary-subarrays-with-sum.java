class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return cnt(nums,goal)-cnt(nums,goal-1);
    }

    public int cnt(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int sum = 0;
        if(goal < 0)return 0;

        while(r < nums.length){
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