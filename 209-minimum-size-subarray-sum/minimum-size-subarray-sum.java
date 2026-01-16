class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;

        while(r<n){
            sum+=nums[r];

            while(sum>=target){
                minlen=Math.min(minlen,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        
        if(minlen==Integer.MAX_VALUE)return 0;
        else return minlen;
    }
}