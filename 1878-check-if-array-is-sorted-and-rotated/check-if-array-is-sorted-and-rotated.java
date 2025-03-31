class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        int pivot = -1;

        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] > nums[i+1]){
                pivot = i+1;
            }
        }

        if(pivot == -1){
            return true;
        }

        for(int i = 0 ; i < pivot-1 ;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }

        for(int i = pivot ; i < nums.length-1 ;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }

        return nums[0] >= nums[nums.length-1];
    }
}