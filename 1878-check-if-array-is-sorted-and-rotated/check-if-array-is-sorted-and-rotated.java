class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        for(int i = 0 ; i < n-1 ;i++){
            if(nums[i] > nums[i+1]){
                pivot = i+1;
            }
        }

        if(pivot == -1){
            return true;
        }

        for(int i = 0 ; i < pivot-1 ; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }

        for(int i = pivot ; i < n-1 ; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }

        return nums[0] >= nums[n-1];
    }
}