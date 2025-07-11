class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxInd = 0;
        
        if(nums.length == 1 && nums[0] == 0)return true;
        if(nums[0] == 0)return false;

        boolean allPos = true;
        for(int num : nums){
            if(num == 0){
                allPos = false;
                break;
            }
        }
        if(allPos == true)return true;

        for(int i = 0 ; i < n ; i++){
            if(i > maxInd){
                return false;
            }
            maxInd = Math.max(maxInd,nums[i]+i);
            if(maxInd >= n)return true;
        }
        return true;
    }
}