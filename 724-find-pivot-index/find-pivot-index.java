class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum =0;
        int rightSum =0,leftSum=0;
        for(int num : nums)sum+=num;

        for(int i = 0 ; i < n ; i++){
            rightSum = sum-leftSum-nums[i];
            if(leftSum== rightSum)return i;
            leftSum += nums[i];
        }
        return -1;
    }
}