class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;

        while(r < nums.length){
            if(nums[l] == nums[r])r++;
            else{
                l++;
                nums[l] = nums[r];
            }
        }
        return l+1;
    }
}