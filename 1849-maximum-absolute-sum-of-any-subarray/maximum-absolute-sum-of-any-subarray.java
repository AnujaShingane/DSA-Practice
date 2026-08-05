class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int one = Math.abs(maxKadane(nums));
        int two = Math.abs(minKadane(nums));

        return Math.max(one,two);
    }

    public int maxKadane(int[] nums){
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            currSum = Math.max(nums[i],nums[i]+currSum);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }

    public int minKadane(int[] nums){
        int n = nums.length;
        int currSum = nums[0];
        int minSum = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            currSum = Math.min(nums[i],nums[i]+currSum);
            minSum = Math.min(currSum,minSum);
        }

        return minSum;
    }
}