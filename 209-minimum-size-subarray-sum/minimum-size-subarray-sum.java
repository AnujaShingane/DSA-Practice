class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while(r<n){
            sum+=nums[r];

            while(sum>=target){
                len = Math.min(len,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }

        return (len==Integer.MAX_VALUE) ? 0 : len;
    }
}