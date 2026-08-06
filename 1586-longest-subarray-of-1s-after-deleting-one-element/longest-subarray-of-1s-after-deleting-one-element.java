class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int len = 0;
        int l = 0;
        int r = 0;

        while(r<n){
            if(nums[r]==0){
                zeros++;
            }

            while(zeros>1){
                if(nums[l]==0)zeros--;
                l++;
            }

            len = Math.max(len,r-l+1);
            r++;
        }

        return len-1;
    }
}