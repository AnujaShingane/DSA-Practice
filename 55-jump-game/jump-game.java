class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            if(i > maxLen)return false;
            maxLen = Math.max(maxLen,i+nums[i]);
            if(maxLen >= nums.length)return true;
        }
        return true;
    }
}