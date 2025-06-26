class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;

        while(r < nums.length){
            if(nums[l] != 0){
                l++;
                r++;
            }else{
                while(nums[r] == 0){
                    if(r == nums.length-1)break;
                    r++;
                }
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            }
        }
    }
}