class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int num = nums[0];

        while(r<n){
            if(nums[r]==num){
                r++;
            }else{
                l++;
                nums[l]=nums[r];
                num = nums[r];
            }
        }

        return l+1;
    }
}